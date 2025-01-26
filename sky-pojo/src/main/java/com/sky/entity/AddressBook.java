package com.sky.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Address Book.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressBook implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * The address id.
     */
    private Long id;

    /**
     * The user id.
     */
    private Long userId;

    /**
     * The consignee.
     */
    private String consignee;

    /**
     * The phone.
     */
    private String phone;

    /**
     * The sex: 0 female, 1 male
     */
    private String sex;

    /**
     * The province code.
     */
    private String provinceCode;

    /**
     * The province name.
     */
    private String provinceName;

    /**
     * The city code.
     */
    private String cityCode;

    /**
     * The city name.
     */
    private String cityName;

    /**
     * The district code.
     */
    private String districtCode;

    /**
     * The district name.
     */
    private String districtName;

    /**
     * The detail address.
     */
    private String detail;

    /**
     * The label.
     */
    private String label;

    /**
     * Is default address: 0 false, 1 true
     */
    private Integer isDefault;
}
