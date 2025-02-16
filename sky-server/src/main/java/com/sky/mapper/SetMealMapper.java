package com.sky.mapper;

import java.util.List;

import com.github.pagehelper.Page;
import com.sky.annotation.Autofill;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.enumeration.OperationType;
import com.sky.vo.SetmealVO;

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

    /**
     * Setmeal page query.
     *
     * @param pageQueryDTO the {@code SetmealPageQueryDTO}
     * @return page of {@code SetmealVO}
     */
    Page<SetmealVO> pageQuery(SetmealPageQueryDTO pageQueryDTO);

    /**
     * Update setmeal.
     *
     * @param setmeal the {@code Setmeal}
     */
    @Autofill(OperationType.UPDATE)
    void update(Setmeal setmeal);

    /**
     * Find by id.
     *
     * @param id the setmeal id.
     * @return the matched {@code Setmeal}
     */
    Setmeal findById(Long id);

    /**
     * Find setmeal by ids.
     *
     * @param ids the list of ids.
     * @return the list of {@code Setmeal}
     */
    List<Setmeal> findByIds(List<Long> ids);

    /**
     * Delete all by ids.
     *
     * @param ids the list of ids
     */
    void deleteAll(List<Long> ids);
}
