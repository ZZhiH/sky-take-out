package com.sky.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The SetmealOverViewVO.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SetmealOverViewVO implements Serializable {

    /**
     * The sold number.
     */
    private Integer sold;

    /**
     * The discontinued.
     */
    private Integer discontinued;
}
