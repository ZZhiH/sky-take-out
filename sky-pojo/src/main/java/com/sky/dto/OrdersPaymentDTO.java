package com.sky.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * Order payment dto.
 */
@Data
public class OrdersPaymentDTO implements Serializable {

    /**
     * Order number.
     */
    private String orderNumber;

    /**
     * Pay method.
     */
    private Integer payMethod;

}
