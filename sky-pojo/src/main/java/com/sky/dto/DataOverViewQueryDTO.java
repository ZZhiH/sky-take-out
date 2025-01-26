package com.sky.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The DataOverViewQueryDTO.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataOverViewQueryDTO implements Serializable {

    /**
     * Begin date.
     */
    private LocalDateTime begin;

    /**
     * End date.
     */
    private LocalDateTime end;

}
