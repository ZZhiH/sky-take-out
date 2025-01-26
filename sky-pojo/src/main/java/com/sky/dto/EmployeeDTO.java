package com.sky.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * The EmployeeDTO.
 */
@Data
public class EmployeeDTO implements Serializable {

    /**
     * Employee id.
     */
    private Long id;

    /**
     * Username.
     */
    private String username;

    /**
     * Name.
     */
    private String name;

    /**
     * Phone number.
     */
    private String phone;

    /**
     * Sex.
     */
    private String sex;

    /**
     * Id number.
     */
    private String idNumber;
}
