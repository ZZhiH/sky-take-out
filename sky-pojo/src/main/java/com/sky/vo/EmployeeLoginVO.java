package com.sky.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The EmployeeLoginVO.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "The data format returned for employee login")
public class EmployeeLoginVO implements Serializable {

    /**
     * The id
     */
    @ApiModelProperty("Primary key")
    private Long id;

    /**
     * The username.
     */
    @ApiModelProperty("username")
    private String userName;

    /**
     * The name.
     */
    @ApiModelProperty("name")
    private String name;

    /**
     * The JWT token
     */
    @ApiModelProperty("jwt token")
    private String token;

}
