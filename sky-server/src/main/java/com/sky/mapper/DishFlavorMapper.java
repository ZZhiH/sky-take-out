package com.sky.mapper;

import java.util.List;

import com.sky.entity.DishFlavor;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * The DishFlavorMapper interface.
 * <p>
 * Creator：ZHIHAO
 * Create date：2025/2/4 22:11
 */
@Mapper
public interface DishFlavorMapper {

    /**
     * Batch insert dish flavors.
     *
     * @param dishFlavorList list of {@code DishFlavor}
     */
    void insertBatch(List<DishFlavor> dishFlavorList);

    /**
     * Find dish flavor by id.
     *
     * @param dishId the dish id
     * @return the list of {@code DishFlavor}
     */
    @Select("select * from dish_flavor where dish_id = #{dishId}")
    List<DishFlavor> findByDishId(Long dishId);

    /**
     * Batch update dish flavors.
     *
     * @param flavors the list of {@code DishFlavor}
     */
    void updateBatch(List<DishFlavor> flavors);

    /**
     * Find all dish flavor by dish ids.
     *
     * @param dishIds the list of dish id
     * @return list of {@code DishFlavor}
     */
    List<DishFlavor> findByDishIdIn(List<Long> dishIds);

    /**
     * Batch delete by dish ids.
     *
     * @param dishIds the list of dish ids.
     */
    void deleteAllByDishIds(List<Long> dishIds);

    /**
     * Create a new dish flavor.
     *
     * @param dishFlavor the {@code DishFlavor}
     */
    void insert(DishFlavor dishFlavor);

    /**
     * Update dish flavor.
     *
     * @param dishFlavor the {@code DishFlavor}
     */
    void update(DishFlavor dishFlavor);

    /**
     * Batch delete by ids.
     *
     * @param ids list of ids
     */
    void deleteAllById(List<Long> ids);
}
