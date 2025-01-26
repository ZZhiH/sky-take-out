package com.sky.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.sky.entity.OrderDetail;

import lombok.Data;

/**
 * The OrdersDTO.
 */
@Data
public class OrdersDTO implements Serializable {

    /**
     * Order id.
     */
    private Long id;

    /**
     * Order number.
     */
    private String number;

    /**
     * Order status: 1 pending payment, 2 awaiting delivery, 3 delivery, 4 complete, 5 cancel.
     */
    private Integer status;

    /**
     * Order user id.
     */
    private Long userId;

    /**
     * Address id.
     */
    private Long addressBookId;

    /**
     * Order time.
     */
    private LocalDateTime orderTime;

    /**
     * Checkout time.
     */
    private LocalDateTime checkoutTime;

    /**
     * pay method: 1 WeChat, 2 aliPay
     */
    private Integer payMethod;

    /**
     * The amount.
     */
    private BigDecimal amount;

    /**
     * The remark.
     */
    private String remark;

    /**
     * The username.
     */
    private String userName;

    /**
     * The phone.
     */
    private String phone;

    /**
     * The address.
     */
    private String address;

    /**
     * Consignee.
     */
    private String consignee;

    /**
     * List of {@code OrderDetail}.
     */
    private List<OrderDetail> orderDetails;

}
