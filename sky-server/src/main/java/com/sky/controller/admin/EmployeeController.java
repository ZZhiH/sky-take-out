package com.sky.controller.admin;

import java.util.HashMap;
import java.util.Map;

import com.sky.constant.JwtClaimsConstant;
import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.dto.PasswordEditDTO;
import com.sky.entity.Employee;
import com.sky.properties.JwtProperties;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.EmployeeService;
import com.sky.utils.JwtUtil;
import com.sky.vo.EmployeeLoginVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Employee Management Controller.
 */
@RestController
@RequestMapping("/admin/employee")
@Slf4j
@Api(tags = "Employee related interface")
public class EmployeeController {

    /**
     * The employee service.
     */
    private final EmployeeService employeeService;

    /**
     * The jwt properties.
     */
    private final JwtProperties jwtProperties;

    /**
     * The construct with specific parameters.
     *
     * @param employeeService the EmployeeService
     * @param jwtProperties   the JwtProperties
     */
    public EmployeeController(final EmployeeService employeeService, final JwtProperties jwtProperties) {
        this.employeeService = employeeService;
        this.jwtProperties = jwtProperties;
    }


    /**
     * Login.
     *
     * @param employeeLoginDTO the EmployeeLoginDTO
     * @return EmployeeLoginVO
     */
    @PostMapping("/login")
    @ApiOperation(value = "Employee login")
    public Result<EmployeeLoginVO> login(@RequestBody EmployeeLoginDTO employeeLoginDTO) {
        log.info("Employee login：{}", employeeLoginDTO);

        Employee employee = employeeService.login(employeeLoginDTO);

        // Login successful, generate jwt token.
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.EMP_ID, employee.getId());
        String token = JwtUtil.createJWT(
            jwtProperties.getAdminSecretKey(),
            jwtProperties.getAdminTtl(),
            claims);

        EmployeeLoginVO employeeLoginVO = EmployeeLoginVO.builder()
            .id(employee.getId())
            .userName(employee.getUsername())
            .name(employee.getName())
            .token(token)
            .build();

        return Result.success(employeeLoginVO);
    }

    /**
     * Logout.
     *
     * @return String.
     */
    @PostMapping("/logout")
    @ApiOperation(value = "Employee logout")
    public Result<String> logout() {
        return Result.success();
    }

    /**
     * Create new employee.
     *
     * @param employeeDTO the EmployeeDTO
     * @return void
     */
    @PostMapping
    @ApiOperation(value = "Create new employee")
    public Result<Void> save(@RequestBody @Valid final EmployeeDTO employeeDTO) {
        log.info("Create employee: {}", employeeDTO);

        this.employeeService.createEmployee(employeeDTO);
        return Result.success();
    }

    /**
     * Employee paginated searcher.
     *
     * @param name     the employee name
     * @param page     the page number
     * @param pageSize the page size.
     * @return result of pageResult
     */
    @GetMapping("/page")
    @ApiOperation(value = "Employee page query")
    public Result<PageResult> page(@RequestParam(value = "name", required = false) final String name,
                                   @RequestParam(value = "page", defaultValue = "1") final Integer page,
                                   @RequestParam(value = "pageSize", defaultValue = "10") final Integer pageSize) {
        log.info("Find employees: name={}, page={}, pageSize={}", name, page, pageSize);

        EmployeePageQueryDTO pageQueryDTO = EmployeePageQueryDTO.builder()
            .name(name)
            .page(page)
            .pageSize(pageSize)
            .build();

        PageResult pageResult = this.employeeService.pageQuery(pageQueryDTO);

        return Result.success(pageResult);
    }

    /**
     * Enable/disable employee account
     *
     * @param status the account status, 1 enable 0 disable
     * @param id     the employee id
     * @return
     */
    @PostMapping("/status/{status}")
    @ApiOperation(value = "Enable/disable employee account")
    public Result<Void> enableOrDisableEmployee(@PathVariable("status") final Integer status,
                                                @RequestParam(value = "id") final Long id) {
        log.info("Enable/disable employee account: status={}, id={}", status, id);

        this.employeeService.enableDisableEmployeeAccount(status, id);

        return Result.success();
    }

    /**
     * Find employee by id.
     *
     * @param id the employee id
     * @return the matched employee
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "Find employee by id")
    public Result<Employee> findEmployeeById(@PathVariable("id") final Long id) {
        log.info("Find employee by id: {}", id);

        Employee employeeDTO = this.employeeService.findEmployeeById(id);

        return Result.success(employeeDTO);
    }

    /**
     * Update employee.
     */
    @PutMapping
    @ApiOperation(value = "Update employee")
    public Result<Void> updateEmployeeById(@RequestBody @Valid final EmployeeDTO employeeDTO) {
        log.info("Update employee: {}", employeeDTO);

        this.employeeService.updateEmployee(employeeDTO);

        return Result.success();
    }

    @PutMapping("/editPassword")
    @ApiOperation(value = "Edit password")
    public Result<Void> editPassword(@RequestBody final PasswordEditDTO passwordEditDTO) {
        log.info("Edit password: {}", passwordEditDTO);

        this.employeeService.editPassword(passwordEditDTO);

        return Result.success();
    }
}
