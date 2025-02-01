package com.sky.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.constant.StatusConstant;
import com.sky.context.BaseContext;
import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.mapper.CategoryMapper;
import com.sky.result.PageResult;
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
    public CategoryServiceImpl(final CategoryMapper categoryMapper) {
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

    @Override
    public PageResult pageQuery(final CategoryPageQueryDTO categoryPageQueryDTO) {
        log.info("Category page query: {}", categoryPageQueryDTO);

        PageHelper.startPage(categoryPageQueryDTO.getPage(), categoryPageQueryDTO.getPageSize());

        Page<Category> page = this.categoryMapper.pageQuery(categoryPageQueryDTO);

        long total = page.getTotal();
        List<Category> records = page.getResult();

        return new PageResult(total, records);
    }

    @Override
    public void enableDisableCategory(final Integer status, Long id) {
        log.info("Enable or disable category: status={}, id={}", status, id);

        Category category = Category.builder()
            .id(id)
            .status(status)
            .updateUser(BaseContext.getCurrentId())
            .updateTime(LocalDateTime.now())
            .build();

        this.categoryMapper.update(category);
    }

    @Override
    public void delete(final Long id) {
        log.info("Delete by id: {}", id);

        this.categoryMapper.deleteById(id);
    }

    @Override
    public List<Category> getCategoryList(Integer type) {
        log.info("Get category list by type: {}", type);

        return this.categoryMapper.findCategoryListByType(type);
    }

    @Override
    public void updateCategory(CategoryDTO categoryDTO) {
        log.info("Update category: {}", categoryDTO);

        Category category = new Category();

        // copy properties
        BeanUtils.copyProperties(categoryDTO, category);

        // set update data
        category.setUpdateTime(LocalDateTime.now());
        category.setUpdateUser(BaseContext.getCurrentId());

        this.categoryMapper.update(category);
    }
}
