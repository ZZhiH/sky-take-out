package com.sky.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * The UserLoginDTO.
 */
@Data
public class UserLoginDTO implements Serializable {

    /**
     * The user login code.
     */
    private String code;

}
