package com.sky.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The UserReportVO.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserReportVO implements Serializable {

    /**
     * The list of date, example: 2022-10-01,2022-10-02,2022-10-03
     */
    private String dateList;

    /**
     * The list of total user, example: 200,210,220
     */
    private String totalUserList;

    /**
     * The list of new user: 20,21,10
     */
    private String newUserList;

}
