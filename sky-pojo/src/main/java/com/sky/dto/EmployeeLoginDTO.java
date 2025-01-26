package com.sky.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * The EmployeeLoginDTO.
 */
@Data
@ApiModel(description = "Data model when employee login")
public class EmployeeLoginDTO implements Serializable {

    /**
     * The username.
     */
    @ApiModelProperty("username")
    private String username;

    /**
     * The password.
     */
    @ApiModelProperty("password")
    private String password;

}
