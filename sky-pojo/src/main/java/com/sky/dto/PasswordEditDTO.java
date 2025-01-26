package com.sky.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * The PasswordEditDTO.
 */
@Data
public class PasswordEditDTO implements Serializable {

    /**
     * The employee id.
     */
    private Long empId;

    /**
     * The old password.
     */
    private String oldPassword;

    /**
     * The new password.
     */
    private String newPassword;

}
