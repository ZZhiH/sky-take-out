package com.sky.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The OrderReportVO.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderReportVO implements Serializable {

    /**
     * The list of date, example: 2022-10-01,2022-10-02,2022-10-03
     */
    private String dateList;

    /**
     * The list of order counter, example: 260,210,215
     */
    private String orderCountList;

    /**
     * The list of valid orders, example: 20,21,10
     */
    private String validOrderCountList;

    /**
     * The total order counter.
     */
    private Integer totalOrderCount;

    /**
     * The valid order counter.
     */
    private Integer validOrderCount;

    /**
     * The order completion rate.
     */
    private Double orderCompletionRate;

}
