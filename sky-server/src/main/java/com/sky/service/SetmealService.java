package com.sky.service;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;

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

    /**
     * Setmeal page query.
     *
     * @param pageQueryDTO the {@code SetmealPageQueryDTO}
     * @return the PageResult of {@code PageResult}
     */
    PageResult pageQuery(SetmealPageQueryDTO pageQueryDTO);
}
