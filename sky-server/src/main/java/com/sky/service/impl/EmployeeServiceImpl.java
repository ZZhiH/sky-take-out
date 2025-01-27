package com.sky.service.impl;

import java.util.Objects;

import com.sky.constant.MessageConstant;
import com.sky.constant.StatusConstant;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.entity.Employee;
import com.sky.exception.AccountLockedException;
import com.sky.exception.AccountNotFoundException;
import com.sky.exception.PasswordErrorException;
import com.sky.mapper.EmployeeMapper;
import com.sky.service.EmployeeService;

import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * The implementation of {@link EmployeeService}.
 */
@Service
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

}
