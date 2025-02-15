package com.sky.mapper;

import com.sky.annotation.Autofill;
import com.sky.entity.Setmeal;
import com.sky.enumeration.OperationType;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * The SetMealMapper interface.
 * <p>
 * Creator：ZHIHAO
 * Create date：2025/2/1 19:49
 */
@Mapper
public interface SetMealMapper {

    /**
     * Get setMeal count by category id.
     *
     * @param categoryId the category id
     * @return the setMeal count
     */
    @Select("select count(id) from setmeal where category_id = #{categoryId}")
    Integer countByCategoryId(Long categoryId);

    /**
     * Create new setmeal
     *
     * @param setmeal the {@code Setmeal}
     */
    @Autofill(OperationType.INSERT)
    void insert(Setmeal setmeal);
}
