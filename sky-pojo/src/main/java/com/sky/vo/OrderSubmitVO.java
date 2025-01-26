package com.sky.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The OrderSubmitVO.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderSubmitVO implements Serializable {

    /**
     * The order id.
     */
    private Long id;

    /**
     * The order number.
     */
    private String orderNumber;

    /**
     * The order amount.
     */
    private BigDecimal orderAmount;

    /**
     * The order time.
     */
    private LocalDateTime orderTime;
}
