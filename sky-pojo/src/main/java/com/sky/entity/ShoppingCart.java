package com.sky.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The ShoppingCart.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCart implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * The shopping cart id.
     */
    private Long id;

    /**
     * The name.
     */
    private String name;

    /**
     * The user id.
     */
    private Long userId;

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

    /**
     * The create time.
     */
    private LocalDateTime createTime;
}
