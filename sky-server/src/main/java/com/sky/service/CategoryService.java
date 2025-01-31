package com.sky.service;

import com.sky.dto.CategoryDTO;

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
}
