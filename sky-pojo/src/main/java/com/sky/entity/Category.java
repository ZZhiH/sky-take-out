package com.sky.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Category.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * The category id.
     */
    private Long id;

    /**
     * Type: 1 dish, 2 set meal
     */
    private Integer type;

    /**
     * The category name.
     */
    private String name;

    /**
     * The sort.
     */
    private Integer sort;

    /**
     * The status: 0 disable, 1 enable
     */
    private Integer status;

    /**
     * Create time.
     */
    private LocalDateTime createTime;

    /**
     * Update time.
     */
    private LocalDateTime updateTime;

    /**
     * Create user.
     */
    private Long createUser;

    /**
     * Update user.
     */
    private Long updateUser;
}
