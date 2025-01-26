package com.sky.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The UserLoginVO.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginVO implements Serializable {

    /**
     * The user login id.
     */
    private Long id;

    /**
     * The WeChat openid.
     */
    private String openid;

    /**
     * The jwt token.
     */
    private String token;

}
