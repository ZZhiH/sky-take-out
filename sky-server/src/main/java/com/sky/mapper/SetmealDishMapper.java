package com.sky.mapper;

import java.util.List;

import com.sky.entity.SetmealDish;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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

    /**
     * Find setmeal dishes by setmeal id.
     *
     * @param setmealId the setmeal id
     * @return list of {@code SetmealDish}
     */
    @Select("select * from setmeal_dish where setmeal_id = #{setmealId}")
    List<SetmealDish> findBySetmealId(Long setmealId);

    /**
     * Delete all by ids.
     *
     * @param ids the list of ids
     */
    void deleteAllByIds(List<Long> ids);

    /**
     * Update setmeal dish.
     *
     * @param setmealDish the {@code SetmealDish}
     */
    void update(SetmealDish setmealDish);

    /**
     * Insert new setmeal dish.
     *
     * @param setmealDish the {@code SetmealDish}
     */
    void insert(SetmealDish setmealDish);

    /**
     * Find all setmeal dish by setmeal id list.
     *
     * @param setmealIds the list of setmeal ids.
     * @return the list of {@code SetmealDish}
     */
    List<SetmealDish> findBySetmealIdIn(List<Long> setmealIds);
}
