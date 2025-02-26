package com.sky.service.admin;

import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.dto.PasswordEditDTO;
import com.sky.entity.Employee;
import com.sky.result.PageResult;

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

    /**
     * Find employees by pageQueryDTO.
     *
     * @param pageQueryDTO the page query
     * @return {@code PageResult}
     */
    PageResult pageQuery(EmployeePageQueryDTO pageQueryDTO);

    /**
     * Enable/disable employee account with given status and employee id.
     *
     * @param status the status, 1 enable, 0 disable
     * @param id     the employee id
     */
    void enableDisableEmployeeAccount(Integer status, Long id);

    /**
     * Find employee by id.
     *
     * @param id the employee id
     * @return the matched {@code Employee}
     */
    Employee findEmployeeById(Long id);

    /**
     * Update employee.
     *
     * @param employeeDTO the {@code Employee}
     */
    void updateEmployee(EmployeeDTO employeeDTO);

    /**
     * Edit employee password.
     *
     * @param passwordEditDTO the {@code PasswordEditDTO}
     */
    void editPassword(PasswordEditDTO passwordEditDTO);
}
