package com.sky.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Setmeal dish.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SetmealDish implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * Setmeal id.
     */
    private Long setmealId;

    /**
     * Dish id.
     */
    private Long dishId;

    /**
     * Dish name.
     */
    private String name;

    /**
     * Dish price.
     */
    private BigDecimal price;

    /**
     * Copies.
     */
    private Integer copies;
}
