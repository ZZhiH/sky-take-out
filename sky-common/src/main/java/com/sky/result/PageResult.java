package com.sky.result;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Paging results.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult implements Serializable {

    /**
     * Number of total records.
     */
    private long total;

    /**
     * List of current page data.
     */
    private List records;

}
