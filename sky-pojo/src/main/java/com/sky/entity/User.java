package com.sky.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The user.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * The user id.
     */
    private Long id;

    /**
     * The WeChat openid.
     */
    private String openid;

    /**
     * The name.
     */
    private String name;

    /**
     * The phone number.
     */
    private String phone;

    /**
     * The sex: 0 female, 1 male
     */
    private String sex;

    /**
     * The id number.
     */
    private String idNumber;

    /**
     * The avatar.
     */
    private String avatar;

    /**
     * Create time.
     */
    private LocalDateTime createTime;
}
