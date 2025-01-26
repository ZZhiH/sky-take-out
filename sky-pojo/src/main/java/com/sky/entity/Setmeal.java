package com.sky.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The set meal.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Setmeal implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * The set meal id.
     */
    private Long id;

    /**
     * The category id.
     */
    private Long categoryId;

    /**
     * The set meal name.
     */
    private String name;

    /**
     * The set meal price.
     */
    private BigDecimal price;

    /**
     * The status: 0 deactivate, 1 activate
     */
    private Integer status;

    /**
     * The description.
     */
    private String description;

    /**
     * The image.
     */
    private String image;

    /**
     * The create time.
     */
    private LocalDateTime createTime;

    /**
     * The update time.
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
