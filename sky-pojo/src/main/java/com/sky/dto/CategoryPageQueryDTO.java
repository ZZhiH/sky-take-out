package com.sky.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * The CategoryPageQueryDTO.
 */
@Data
public class CategoryPageQueryDTO implements Serializable {

    /**
     * Page
     */
    private int page;

    /**
     * Page size.
     */
    private int pageSize;

    /**
     * Page name.
     */
    private String name;

    /**
     * Type: 1 dishes, 2 set meal
     */
    private Integer type;

}
