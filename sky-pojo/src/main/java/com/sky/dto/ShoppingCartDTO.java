package com.sky.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * The ShoppingCartDTO.
 */
@Data
public class ShoppingCartDTO implements Serializable {

    /**
     * The dish id.
     */
    private Long dishId;

    /**
     * Set meal id.
     */
    private Long setmealId;

    /**
     * The dish flavor.
     */
    private String dishFlavor;

}
