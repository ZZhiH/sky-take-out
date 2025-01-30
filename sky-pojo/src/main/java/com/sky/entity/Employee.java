package com.sky.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The employee.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * The employee id.
     */
    private Long id;

    /**
     * The username.
     */
    private String username;

    /**
     * The employee name.
     */
    private String name;

    /**
     * The employee password.
     */
    private String password;

    /**
     * The employee phone.
     */
    private String phone;

    /**
     * The employee sex.
     */
    private String sex;

    /**
     * The employee id number.
     */
    private String idNumber;

    /**
     * Status.
     */
    private Integer status;

    /**
     * Create time.
     */
    private LocalDateTime createTime;

    /**
     * Update time.
     */
    private LocalDateTime updateTime;

    /**
     * The create user.
     */
    private Long createUser;

    /**
     * The update user.
     */
    private Long updateUser;

}
