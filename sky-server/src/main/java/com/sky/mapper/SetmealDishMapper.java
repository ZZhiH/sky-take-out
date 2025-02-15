package com.sky.mapper;

import java.util.List;

import com.sky.entity.SetmealDish;

import org.apache.ibatis.annotations.Mapper;

/**
 * The SetmealDishMapper interface.
 * <p>
 * Creator：ZHIHAO
 * Create date：2025/2/15 22:20
 */
@Mapper
public interface SetmealDishMapper {

    int countByDishIds(List<Long> dishIds);

    /**
     * Batch insert setmeal dishes.
     *
     * @param setmealDishes the list of {@code SetmealDish}
     */
    void insertAll(List<SetmealDish> setmealDishes);
}
