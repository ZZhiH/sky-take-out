package com.sky.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * The DishPageQueryDTO.
 */
@Data
public class DishPageQueryDTO implements Serializable {

    /**
     * Page.
     */
    private int page;

    /**
     * Page size.
     */
    private int pageSize;

    /**
     * Page name
     */
    private String name;

    /**
     * Category id.
     */
    private Integer categoryId;

    /**
     * Status: 0 disabled, 1 enabled.
     */
    private Integer status;

}
