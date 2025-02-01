package com.sky.mapper;

import org.apache.ibatis.annotations.Select;

/**
 * The SetMealMapper interface.
 * <p>
 * Creator：ZHIHAO
 * Create date：2025/2/1 19:49
 */
public interface SetMealMapper {

    /**
     * Get setMeal count by category id.
     *
     * @param categoryId the category id
     * @return the setMeal count
     */
    @Select("select count(id) from setmeal where category_id = #{categoryId}")
    Integer countByCategoryId(Long categoryId);
}
