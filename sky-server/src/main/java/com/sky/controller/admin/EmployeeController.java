package com.sky.controller.admin;

import java.util.HashMap;
import java.util.Map;

import com.sky.constant.JwtClaimsConstant;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.entity.Employee;
import com.sky.properties.JwtProperties;
import com.sky.result.Result;
import com.sky.service.EmployeeService;
import com.sky.utils.JwtUtil;
import com.sky.vo.EmployeeLoginVO;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Employee Management Controller.
 */
@RestController
@RequestMapping("/admin/employee")
@Slf4j
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
    public Result<String> logout() {
        return Result.success();
    }

}
