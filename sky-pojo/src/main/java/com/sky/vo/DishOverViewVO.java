package com.sky.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The DishOverViewVO.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DishOverViewVO implements Serializable {

    /**
     * The sold.
     */
    private Integer sold;

    /**
     * The discontinued.
     */
    private Integer discontinued;
}
