package com.sky.mapper;

import com.sky.entity.Employee;

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

}
