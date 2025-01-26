package com.sky.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * The SetmealPageQueryDTO.
 */
@Data
public class SetmealPageQueryDTO implements Serializable {

    /**
     * The page.
     */
    private int page;

    /**
     * The page size.
     */
    private int pageSize;

    /**
     * The page size.
     */
    private String name;

    /**
     * The category id.
     */
    private Integer categoryId;

    /**
     * They set meal status: 0 deactivate, 1 activate
     */
    private Integer status;

}
