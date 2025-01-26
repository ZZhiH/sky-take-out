package com.sky.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The DishItemVO.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DishItemVO implements Serializable {

    /**
     * The dish name.
     */
    private String name;

    /**
     * The copies.
     */
    private Integer copies;

    /**
     * The dish image.
     */
    private String image;

    /**
     * The dish description.
     */
    private String description;
}
