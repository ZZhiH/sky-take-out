package com.sky.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The EmployeeDTO.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
