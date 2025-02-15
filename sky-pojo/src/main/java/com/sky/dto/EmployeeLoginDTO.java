package com.sky.dto;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * The EmployeeLoginDTO.
 */
@Data
@Schema(description = "Data model when employee login")
public class EmployeeLoginDTO implements Serializable {

    /**
     * The username.
     */
    @Schema(description = "username")
    private String username;

    /**
     * The password.
     */
    @Schema(description = "password")
    private String password;

}
