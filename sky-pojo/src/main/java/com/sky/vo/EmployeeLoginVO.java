package com.sky.vo;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "The data format returned for employee login")
public class EmployeeLoginVO implements Serializable {

    /**
     * The id
     */
    @Schema(description = "Primary key")
    private Long id;

    /**
     * The username.
     */
    @Schema(description = "username")
    private String userName;

    /**
     * The name.
     */
    @Schema(description = "name")
    private String name;

    /**
     * The JWT token
     */
    @Schema(description = "jwt token")
    private String token;

}
