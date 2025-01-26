package com.sky.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * The OrdersConfirmDTO.
 */
@Data
public class OrdersConfirmDTO implements Serializable {

    /**
     * Order confirm id.
     */
    private Long id;

    /**
     * Order status: 1 pending payment, 2 pending orders, 3 Order received, 4 Delivery, 5 Complete, 6 Cancel, 7 Refund
     */
    private Integer status;

}
