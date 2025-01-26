package com.sky.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * The OrdersCancelDTO.
 */
@Data
public class OrdersCancelDTO implements Serializable {

    /**
     * Order cancel reason.
     */
    private Long id;

    /**
     * Order cancel reason.
     */
    private String cancelReason;

}
