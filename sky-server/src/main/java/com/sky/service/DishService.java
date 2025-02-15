package com.sky.service;

import java.util.List;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.result.PageResult;

/**
 * The DishService interface.
 * <p>
 * Creator：ZHIHAO
 * Create date：2025/2/4 22:00
 */
public interface DishService {

    /**
     * Create new dish.
     *
     * @param dishDTO the {@code DishDTO}
     */
    void saveWithFlavor(DishDTO dishDTO);

    /**
     * Find by id.
     *
     * @param id the dish id
     * @return the matched {@code DishDTO}
     */
    DishDTO findById(Long id);

    /**
     * Find by category id.
     *
     * @param categoryId the category id
     * @return the list of {@code Dish}
     */
    List<Dish> findByCategoryId(String categoryId);

    /**
     * Dish page query.
     *
     * @param dishPageQueryDTO the {@code DishPageQueryDTO}
     * @return the PageResult
     */
    PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO);

    /**
     * Enable/disable dish with given status and dish id.
     *
     * @param status the status, 1 enable, 0 disable
     * @param dishId the dish id
     */
    void enableDisableDish(Integer status, Long dishId);

    /**
     * Update dish.
     *
     * @param dishDTO the {@code DishDTO}
     */
    void updateDish(DishDTO dishDTO);
}
