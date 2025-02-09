package com.sky.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The dish flavor.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DishFlavor implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * The dish flavor id.
     */
    private Long id;

    /**
     * The dish id.
     */
    private Long dishId;

    /**
     * The dish name.
     */
    private String name;

    /**
     * The dish flavor data list.
     */
    private String value;

}
