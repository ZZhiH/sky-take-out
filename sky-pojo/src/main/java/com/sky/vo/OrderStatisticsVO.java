package com.sky.vo;

import java.io.Serializable;

import lombok.Data;

/**
 * The OrderStatisticsVO.
 */
@Data
public class OrderStatisticsVO implements Serializable {

    /**
     * The number to be confirmed.
     */
    private Integer toBeConfirmed;

    /**
     * The number of confirmed.
     */
    private Integer confirmed;

    /**
     * The number of delivery in progress.
     */
    private Integer deliveryInProgress;
}
