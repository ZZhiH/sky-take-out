package com.sky.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.sky.entity.DishFlavor;

import lombok.Data;

/**
 * The DishDTO.
 */
@Data
public class DishDTO implements Serializable {

    /**
     * Dish id.
     */
    private Long id;

    /**
     * Dish name.
     */
    private String name;

    /**
     * Dish category id.
     */
    private Long categoryId;

    /**
     * Dish price.
     */
    private BigDecimal price;

    /**
     * Image.
     */
    private String image;

    /**
     * Description.
     */
    private String description;

    /**
     * Status: 0 not on sale, 1 sale
     */
    private Integer status;

    /**
     * Flavors.
     */
    private List<DishFlavor> flavors = new ArrayList<>();

}
