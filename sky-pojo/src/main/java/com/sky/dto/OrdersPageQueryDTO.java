package com.sky.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * The OrdersPageQueryDTO.
 */
@Data
public class OrdersPageQueryDTO implements Serializable {

    /**
     * Page.
     */
    private int page;

    /**
     * Page size.
     */
    private int pageSize;

    /**
     * Page number.
     */
    private String number;

    /**
     * Order phone.
     */
    private String phone;

    /**
     * Order status.
     */
    private Integer status;

    /**
     * Begin time.
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime beginTime;

    /**
     * End time.
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

    /**
     * User id.
     */
    private Long userId;

}
