package com.sky.vo;

import java.io.Serializable;
import java.util.List;

import com.sky.entity.OrderDetail;
import com.sky.entity.Orders;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The OrderVO.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderVO extends Orders implements Serializable {

    /**
     * The order dishes.
     */
    private String orderDishes;

    /**
     * The list of {@code OrderDetail}
     */
    private List<OrderDetail> orderDetailList;

}
