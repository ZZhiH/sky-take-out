package com.sky.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * The PasswordEditDTO.
 */
@Data
public class PasswordEditDTO implements Serializable {

    /**
     * The employee id.
     */
    @NotNull
    private Long empId;

    /**
     * The old password.
     */
    @NotNull
    private String oldPassword;

    /**
     * The new password.
     */
    @NotNull
    private String newPassword;

}
