package com.sky.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * The CategoryPageQueryDTO.
 */
@Data
public class CategoryPageQueryDTO implements Serializable {

    /**
     * Page
     */
    @NotNull
    private int page;

    /**
     * Page size.
     */
    @NotNull
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
