package com.sky.service.impl;

import java.time.LocalDateTime;

import com.sky.constant.StatusConstant;
import com.sky.context.BaseContext;
import com.sky.dto.CategoryDTO;
import com.sky.entity.Category;
import com.sky.mapper.CategoryMapper;
import com.sky.service.CategoryService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

/**
 * The CategoryServiceImpl.
 * <p>
 * Creator：ZHIHAO
 * Create date：2025/1/31 22:10
 */
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    /**
     * The category mapper.
     */
    private final CategoryMapper categoryMapper;

    /**
     * The constructor with specific parameter.
     *
     * @param categoryMapper the Category mapper
     */
    public CategoryServiceImpl(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Override
    public void createCategory(final CategoryDTO categoryDTO) {
        log.info("Create category: {}", categoryDTO);

        Category category = new Category();

        // copy properties
        BeanUtils.copyProperties(categoryDTO, category);

        // set category status
        category.setStatus(StatusConstant.ENABLE);

        category.setCreateTime(LocalDateTime.now());
        category.setCreateUser(BaseContext.getCurrentId());

        this.categoryMapper.insert(category);
    }
}
