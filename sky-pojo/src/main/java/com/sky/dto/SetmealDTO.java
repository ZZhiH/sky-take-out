package com.sky.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.sky.entity.SetmealDish;

import lombok.Data;

/**
 * The SetmealDTO.
 */
@Data
public class SetmealDTO implements Serializable {

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
     * Set meal status: 0 Deactivate, 1 active
     */
    private Integer status;

    /**
     * The description.
     */
    private String description;

    /**
     * Set meal image.
     */
    private String image;

    /**
     * List of {@code SetmealDish}
     */
    private List<SetmealDish> setmealDishes = new ArrayList<>();

}
