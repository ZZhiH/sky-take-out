package com.sky.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.constant.MessageConstant;
import com.sky.constant.PasswordConstant;
import com.sky.constant.StatusConstant;
import com.sky.context.BaseContext;
import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.dto.PasswordEditDTO;
import com.sky.entity.Employee;
import com.sky.exception.AccountLockedException;
import com.sky.exception.AccountNotFoundException;
import com.sky.exception.PasswordEditFailedException;
import com.sky.exception.PasswordErrorException;
import com.sky.mapper.EmployeeMapper;
import com.sky.result.PageResult;
import com.sky.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.util.DigestUtils;

/**
 * The implementation of {@link EmployeeService}.
 */
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    /**
     * The employee mapper.
     */
    private final EmployeeMapper employeeMapper;

    /**
     * The constructor with specific parameter.
     *
     * @param employeeMapper the Employee mapper
     */
    public EmployeeServiceImpl(final EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }


    /**
     * Employee login.
     *
     * @param employeeLoginDTO the EmployeeLoginDTO
     * @return the login Employee
     */
    public Employee login(final EmployeeLoginDTO employeeLoginDTO) {
        String username = employeeLoginDTO.getUsername();
        String password = employeeLoginDTO.getPassword();

        //1、get employee by username
        Employee employee = employeeMapper.getByUsername(username);

        if (employee == null) {
            // employee not found.
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }

        // encrypt with md5
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!password.equals(employee.getPassword())) {
            // password error
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }

        if (Objects.equals(employee.getStatus(), StatusConstant.DISABLE)) {
            // account locked.
            throw new AccountLockedException(MessageConstant.ACCOUNT_LOCKED);
        }

        //3、return employee
        return employee;
    }


    @Override
    public void createEmployee(final EmployeeDTO employeeDTO) {
        log.info("Entering createEmployee: employeeDTO={}", employeeDTO);
        Employee employee = new Employee();

        // copy properties
        BeanUtils.copyProperties(employeeDTO, employee);

        // set account state, default 1
        employee.setStatus(StatusConstant.ENABLE);

        // set default password
        employee.setPassword(DigestUtils.md5DigestAsHex(PasswordConstant.DEFAULT_PASSWORD.getBytes()));

        // set current date
        employee.setCreateTime(LocalDateTime.now());
        employee.setUpdateTime(LocalDateTime.now());

        // set create user
        employee.setCreateUser(BaseContext.getCurrentId());
        employee.setUpdateUser(BaseContext.getCurrentId());

        this.employeeMapper.insert(employee);
    }

    @Override
    public PageResult pageQuery(final EmployeePageQueryDTO pageQueryDTO) {
        log.info("Entering findEmployees: pageQueryDTO={}", pageQueryDTO);
        // select * from employee limit 0, 10

        // page query
        PageHelper.startPage(pageQueryDTO.getPage(), pageQueryDTO.getPageSize());

        Page<Employee> page = this.employeeMapper.pageQuery(pageQueryDTO);

        long total = page.getTotal();
        List<Employee> records = page.getResult();

        return new PageResult(total, records);
    }

    @Override
    public void enableDisableEmployeeAccount(final Integer status, final Long id) {
        log.info("Lock employee: status={}, id={}", status, id);

        Employee employee = Employee.builder()
            .id(id)
            .status(status)
            .build();

        this.employeeMapper.update(employee);

    }

    @Override
    public Employee findEmployeeById(final Long id) {
        log.info("Find employee by id: {}", id);

        Employee employee = this.employeeMapper.findById(id);
        employee.setPassword("****");

        return employee;
    }

    @Override
    public void updateEmployee(final EmployeeDTO employeeDTO) {
        log.info("Update employee: {}", employeeDTO);

        Employee employee = new Employee();

        BeanUtils.copyProperties(employeeDTO, employee);

        this.employeeMapper.update(employee);

    }

    @Override
    public void editPassword(final PasswordEditDTO passwordEditDTO) {
        log.info("Edit password: {}", passwordEditDTO);

        String oldPassword = passwordEditDTO.getOldPassword();
        String newPassword = passwordEditDTO.getNewPassword();

        // find employee by id
        Employee employee = this.employeeMapper.findById(passwordEditDTO.getEmpId());
        if (employee == null) {
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }
        String oldPassMd5 = DigestUtils.md5DigestAsHex(oldPassword.getBytes());

        // compare old password
        if (!oldPassMd5.equals(employee.getPassword())) {
            // throw password edit exception
            throw new PasswordEditFailedException(MessageConstant.PASSWORD_EDIT_FAILED);
        }

        // set new password 
        String newPassMd5 = DigestUtils.md5DigestAsHex(newPassword.getBytes());
        employee.setPassword(newPassMd5);

        this.employeeMapper.update(employee);
    }

}
