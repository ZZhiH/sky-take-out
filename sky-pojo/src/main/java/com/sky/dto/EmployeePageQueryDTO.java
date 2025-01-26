package com.sky.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * The EmployeePageQueryDTO.
 */
@Data
public class EmployeePageQueryDTO implements Serializable {

    /**
     * Employee name.
     */
    private String name;

    /**
     * Page.
     */
    private int page;

    /**
     * Page size.
     */
    private int pageSize;

}
