package com.sky.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The dish.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dish implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * The dish id.
     */
    private Long id;

    /**
     * The dish name.
     */
    private String name;

    /**
     * The category id.
     */
    private Long categoryId;

    /**
     * The dish price.
     */
    private BigDecimal price;

    /**
     * The dish image.
     */
    private String image;

    /**
     * The dish description.
     */
    private String description;

    /**
     * Dish status: 0 not on sale, 1 sale
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
