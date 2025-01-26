package com.sky.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * The category DTO.
 */
@Data
public class CategoryDTO implements Serializable {

    /**
     * Category id.
     */
    private Long id;

    /**
     * Type: 1 dishes, 2 set meal
     */
    private Integer type;

    /**
     * Category name.
     */
    private String name;

    /**
     * Sort.
     */
    private Integer sort;

}
