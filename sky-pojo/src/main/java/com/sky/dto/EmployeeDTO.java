package com.sky.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
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
    @NotNull
    private String username;

    /**
     * Name.
     */
    @NotNull
    private String name;

    /**
     * Phone number.
     */
    @NotNull
    private String phone;

    /**
     * Sex.
     */
    @NotNull
    private String sex;

    /**
     * Id number.
     */
    @NotNull
    private String idNumber;
}
