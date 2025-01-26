package com.sky.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The BusinessDataVO.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusinessDataVO implements Serializable {

    /**
     * The revenue.
     */
    private Double turnover;

    /**
     * The valid order counter.
     */
    private Integer validOrderCount;

    /**
     * The order completion rate.
     */
    private Double orderCompletionRate;

    /**
     * The unit price.
     */
    private Double unitPrice;

    /**
     * The new users.
     */
    private Integer newUsers;

}
