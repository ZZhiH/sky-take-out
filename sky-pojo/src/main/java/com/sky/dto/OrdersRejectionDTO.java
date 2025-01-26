package com.sky.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * The OrdersRejectionDTO.
 */
@Data
public class OrdersRejectionDTO implements Serializable {

    /**
     * The order rejection id.
     */
    private Long id;

    /**
     * The rejection reason.
     */
    private String rejectionReason;

}
