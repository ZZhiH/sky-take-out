package com.sky.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The orders
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Orders implements Serializable {

    /**
     * Order status: 1 pending payment, 2 pending order, 3 orders received, 4 delivery, 5 completed, 6 canceled
     */
    public static final Integer PENDING_PAYMENT = 1;
    public static final Integer TO_BE_CONFIRMED = 2;
    public static final Integer CONFIRMED = 3;
    public static final Integer DELIVERY_IN_PROGRESS = 4;
    public static final Integer COMPLETED = 5;
    public static final Integer CANCELLED = 6;

    /**
     * Payment status: 0 unpaid, 1 paid, 2 refund
     */
    public static final Integer UN_PAID = 0;
    public static final Integer PAID = 1;
    public static final Integer REFUND = 2;

    private static final long serialVersionUID = 1L;

    /**
     * The order id.
     */
    private Long id;

    /**
     * The order number.
     */
    private String number;

    /**
     * The order status: 1 pending payment, 2 pending order, 3 orders received, 4 delivery, 5 completed, 6 canceled,
     * 7 refund.
     */
    private Integer status;

    /**
     * The order user id.
     */
    private Long userId;

    /**
     * The address book id.
     */
    private Long addressBookId;

    /**
     * The order time.
     */
    private LocalDateTime orderTime;

    /**
     * The checkout time.
     */
    private LocalDateTime checkoutTime;

    /**
     * The payment: 1 WeChat, 2 Alipay
     */
    private Integer payMethod;

    /**
     * The Pay status: 0 unpaid, 1 paid, 2 refund
     */
    private Integer payStatus;

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
     * The phone number.
     */
    private String phone;

    /**
     * The address.
     */
    private String address;

    /**
     * The consignee.
     */
    private String consignee;

    /**
     * The order cancel reason.
     */
    private String cancelReason;

    /**
     * The order reject reason.
     */
    private String rejectionReason;

    /**
     * The cancel time.
     */
    private LocalDateTime cancelTime;

    /**
     * The estimated delivery time.
     */
    private LocalDateTime estimatedDeliveryTime;

    /**
     * The delivery status: 1 Send immediately, 0 specific time
     */
    private Integer deliveryStatus;

    /**
     * The delivery time;
     */
    private LocalDateTime deliveryTime;

    /**
     * The pack amount.
     */
    private int packAmount;

    /**
     * The tableware number.
     */
    private int tablewareNumber;

    //餐具数量状态  1按餐量提供  0选择具体数量
    /**
     * The tableware status: 1 per meal, 0 specific quantity
     */
    private Integer tablewareStatus;
}
