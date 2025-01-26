package com.sky.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.sky.entity.DishFlavor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The DishVO.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DishVO implements Serializable {

    /**
     * The id.
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
     * The status: 0 deactivate, 1 activate
     */
    private Integer status;

    /**
     * Update time.
     */
    private LocalDateTime updateTime;

    /**
     * The category name.
     */
    private String categoryName;

    /**
     * The list of {@code DishFlavor}.
     */
    private List<DishFlavor> flavors = new ArrayList<>();

    //private Integer copies;
}
