package com.sky.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The OrderPaymentVO.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderPaymentVO implements Serializable {

    /**
     * The nonce str.
     */
    private String nonceStr;

    /**
     * The pay sign.
     */
    private String paySign;

    /**
     * The timestamp.
     */
    private String timeStamp;

    /**
     * The sign type.
     */
    private String signType;

    /**
     * The package str.
     */
    private String packageStr;

}
