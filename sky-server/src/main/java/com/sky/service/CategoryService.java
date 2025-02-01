package com.sky.service;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.result.PageResult;

/**
 * The Category interface.
 * <p>
 * Creator：ZHIHAO
 * Create date：2025/1/31 22:09
 */
public interface CategoryService {

    /**
     * Create new category.
     *
     * @param categoryDTO the {@code CategoryDTO}
     */
    void createCategory(CategoryDTO categoryDTO);

    /**
     * Category page query.
     *
     * @param categoryPageQueryDTO the {@code CategoryPageQueryDTO}
     * @return the result of {@code PageResult}
     */
    PageResult pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * Enable/disable category with given status and category id.
     *
     * @param status the status 1 enable, 0 disable
     * @param id     the category id
     */
    void enableDisableCategory(Integer status, Long id);
}
