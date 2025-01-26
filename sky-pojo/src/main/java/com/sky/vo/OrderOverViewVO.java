package com.sky.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The OrderOverViewVO.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderOverViewVO implements Serializable {

    /**
     * The waiting orders.
     */
    private Integer waitingOrders;

    /**
     * The delivery orders.
     */
    private Integer deliveredOrders;

    /**
     * The completed orders.
     */
    private Integer completedOrders;

    /**
     * The cancelled orders.
     */
    private Integer cancelledOrders;

    /**
     * All orders.
     */
    private Integer allOrders;
}
