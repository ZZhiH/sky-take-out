package com.sky.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.sky.entity.SetmealDish;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The SetmealVO.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SetmealVO implements Serializable {

    /**
     * The setmeal id.
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
     * Update time.
     */
    private LocalDateTime updateTime;

    /**
     * The category name.
     */
    private String categoryName;

    /**
     * List of {@code SetmealDish}.
     */
    private List<SetmealDish> setmealDishes = new ArrayList<>();
}
