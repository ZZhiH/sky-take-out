package com.sky.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The order detail.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * The order detail id.
     */
    private Long id;

    /**
     * The order detail name.
     */
    private String name;

    /**
     * The order id.
     */
    private Long orderId;

    /**
     * The dish id.
     */
    private Long dishId;

    /**
     * The set meal id.
     */
    private Long setmealId;

    /**
     * The dish flavor.
     */
    private String dishFlavor;

    /**
     * The number.
     */
    private Integer number;

    /**
     * The amount.
     */
    private BigDecimal amount;

    /**
     * The image.
     */
    private String image;
}
