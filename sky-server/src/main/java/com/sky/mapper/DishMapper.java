package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * The DishMapper interface.
 * <p>
 * Creator：ZHIHAO
 * Create date：2025/2/1 19:48
 */
@Mapper
public interface DishMapper {

    /**
     * Get dish count by category id.
     *
     * @param categoryId the category id
     * @return the dish count
     */
    @Select("select count(id) from dish where category_id = #{categoryId}")
    Integer countByCategoryId(Long categoryId);
}
