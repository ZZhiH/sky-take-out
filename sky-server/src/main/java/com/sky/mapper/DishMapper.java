package com.sky.mapper;

import java.util.List;

import com.github.pagehelper.Page;
import com.sky.annotation.Autofill;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.enumeration.OperationType;
import com.sky.vo.DishVO;

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

    /**
     * Create new dish.
     *
     * @param dish the {@code Dish}
     */
    @Autofill(OperationType.INSERT)
    void insert(Dish dish);

    /**
     * Find by id.
     *
     * @param id the dish id
     * @return the matched {@code Dish}
     */
    @Select("select * from dish where id = #{id}")
    Dish findById(Long id);

    /**
     * Find by category id.
     *
     * @param categoryId the category id
     * @return the list of {@code Dish}
     */
    @Select("select * from dish where category_id = #{categoryId}")
    List<Dish> findByCategoryId(String categoryId);

    /**
     * Update dish.
     *
     * @param dish the update dish
     */
    @Autofill(OperationType.UPDATE)
    void update(Dish dish);

    /**
     * Dish page query.
     *
     * @param dishPageQueryDTO the {@code DishPageQueryDTO}
     * @return page of {@code Dish}
     */
    Page<DishVO> pageQuery(DishPageQueryDTO dishPageQueryDTO);

    /**
     * Delete all by ids.
     *
     * @param ids the list of dish id
     */
    void deleteAll(List<Long> ids);

    /**
     * Find all dishes by ids.
     *
     * @param ids the list of ids.
     * @return the list of {@code Dish}
     */
    List<Dish> findByIds(List<Long> ids);
}
