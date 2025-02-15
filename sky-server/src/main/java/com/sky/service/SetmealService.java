package com.sky.service;

import com.sky.dto.SetmealDTO;

/**
 * The SetmealService interface.
 * <p>
 * Creator：ZHIHAO
 * Create date：2025/2/15 21:55
 */
public interface SetmealService {

    /**
     * Create new setmeal.
     *
     * @param setmealDTO the {@code SetmealDTO}
     */
    void save(SetmealDTO setmealDTO);
}
