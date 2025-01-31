package com.sky.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
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
    @NotNull
    private Integer type;

    /**
     * Category name.
     */
    @NotNull
    private String name;

    /**
     * Sort.
     */
    @NotNull
    private Integer sort;

}
