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

    void batchInsert(List<DishFlavor> dishFlavorList);

    @Select("select * from dish_flavor where dish_id = #{id}")
    List<DishFlavor> findByDishId(Long id);
}
