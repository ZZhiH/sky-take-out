package com.sky.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * The OrdersSubmitDTO.
 */
@Data
public class OrdersSubmitDTO implements Serializable {

    /**
     * The address book.
     */
    private Long addressBookId;

    /**
     * The pay method.
     */
    private int payMethod;

    /**
     * The remark.
     */
    private String remark;

    /**
     * Estimate delivery time.
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime estimatedDeliveryTime;

    /**
     * Delivery status: 1 Send immediately, 0 specific time
     */
    private Integer deliveryStatus;

    /**
     * Tableware number.
     */
    private Integer tablewareNumber;

    /**
     * Tableware status: 1 per meal, 0 Specific quantity.
     */
    private Integer tablewareStatus;

    /**
     * Pack amount.
     */
    private Integer packAmount;

    /**
     * Total amount.
     */
    private BigDecimal amount;
}
