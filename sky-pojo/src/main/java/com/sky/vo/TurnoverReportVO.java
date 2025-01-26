package com.sky.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The TurnoverReportVO.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TurnoverReportVO implements Serializable {

    /**
     * The list of date, example: 2022-10-01,2022-10-02,2022-10-03
     */
    private String dateList;

    /**
     * The list of turnover: 406.0,1520.0,75.0
     */
    private String turnoverList;

}
