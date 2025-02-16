package com.sky.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * The SetmealPageQueryDTO.
 */
@Data
public class SetmealPageQueryDTO implements Serializable {

    /**
     * The page.
     */
    @NotNull
    private int page;

    /**
     * The page size.
     */
    @NotNull
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
