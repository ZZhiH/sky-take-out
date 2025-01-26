package com.sky.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The GoodsSalesDTO.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GoodsSalesDTO implements Serializable {

    /**
     * Good sales name.
     */
    private String name;

    /**
     * Sales volume.
     */
    private Integer number;
}
