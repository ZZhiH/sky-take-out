package com.sky.service;

import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.entity.Employee;

/**
 * The employee service.
 */
public interface EmployeeService {

    /**
     * Employee login.
     *
     * @param employeeLoginDTO the EmployeeLoginDTO
     * @return the login Employee
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);

    /**
     * Create new employee.
     *
     * @param employeeDTO the employeeDTO
     */
    void createEmployee(EmployeeDTO employeeDTO);
}
