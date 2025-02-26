package com.sky.service.admin;

import java.util.List;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.vo.SetmealVO;

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

    /**
     * Enable/disable setmeal with given status and setmeal id.
     *
     * @param status    the status, 1 enable, 0 disable
     * @param setmealId the setmeal id
     */
    void enableDisableSetmeal(Integer status, Long setmealId);

    /**
     * Find setmeal by id.
     *
     * @param id the setmeal id
     * @return the matched {@code SetmealVO}
     */
    SetmealVO findById(Long id);

    /**
     * Update with dishes.
     *
     * @param setmealDTO the {@code SetmealDTO}
     */
    void updateWithDishes(SetmealDTO setmealDTO);

    /**
     * Delete setmeal by ids.
     *
     * @param ids the list of ids
     */
    void deleteByIds(List<Long> ids);
}
