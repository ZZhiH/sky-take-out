package com.sky.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The SalesTop10ReportVO.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalesTop10ReportVO implements Serializable {

    /**
     * The list of dish name, example: 鱼香肉丝,宫保鸡丁,水煮鱼
     */
    private String nameList;

    /**
     * The list of sales, example: 260,215,200
     */
    private String numberList;

}
