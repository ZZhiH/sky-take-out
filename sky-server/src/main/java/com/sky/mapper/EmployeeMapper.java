package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.Autofill;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.enumeration.OperationType;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * The employee mapper.
 */
@Mapper
public interface EmployeeMapper {

    /**
     * Get user by username.
     *
     * @param username the username
     * @return the matched Employee
     */
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);

    /**
     * Insert employee data
     *
     * @param employee
     */
    @Autofill(OperationType.INSERT)
    @Insert("insert into employee (username, name, password, phone, sex, id_number, status, create_time, update_time," +
        " create_user, update_user) " +
        "values " +
        "(#{username}, #{name}, #{password}, #{phone}, #{sex}, #{idNumber}, #{status}, #{createTime}, #{updateTime}, " +
        "#{createUser}, #{updateUser})")
    void insert(final Employee employee);


    /**
     * Page query
     *
     * @param pageQueryDTO the {@code EmployeePageQueryDTO}
     * @return page of {@code Employee}
     */
    Page<Employee> pageQuery(EmployeePageQueryDTO pageQueryDTO);

    /**
     * Update employee.
     *
     * @param employee the update employee
     */
    @Autofill(OperationType.UPDATE)
    void update(Employee employee);

    /**
     * Find employee by id.
     *
     * @param id the employee id.
     * @return the matched {@code Employee}
     */
    Employee findById(Long id);
}
