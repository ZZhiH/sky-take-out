package com.sky.service.impl;

import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.constant.MessageConstant;
import com.sky.constant.StatusConstant;
import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.exception.DeletionNotAllowedException;
import com.sky.mapper.CategoryMapper;
import com.sky.mapper.DishMapper;
import com.sky.mapper.SetMealMapper;
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

    private final DishMapper dishMapper;

    private final SetMealMapper setMealMapper;

    /**
     * The constructor with specific parameter.
     *
     * @param categoryMapper the Category mapper
     * @param dishMapper     the Dish mapper
     * @param setMealMapper  The SetMeal mapper
     */
    public CategoryServiceImpl(final CategoryMapper categoryMapper,
                               final DishMapper dishMapper,
                               final SetMealMapper setMealMapper) {
        this.categoryMapper = categoryMapper;
        this.dishMapper = dishMapper;
        this.setMealMapper = setMealMapper;
    }

    @Override
    public void createCategory(final CategoryDTO categoryDTO) {
        log.info("Create category: {}", categoryDTO);

        final Category category = new Category();

        // copy properties
        BeanUtils.copyProperties(categoryDTO, category);

        // set category status
        category.setStatus(StatusConstant.ENABLE);

        this.categoryMapper.insert(category);
    }

    @Override
    public PageResult pageQuery(final CategoryPageQueryDTO categoryPageQueryDTO) {
        log.info("Category page query: {}", categoryPageQueryDTO);

        PageHelper.startPage(categoryPageQueryDTO.getPage(), categoryPageQueryDTO.getPageSize());

        final Page<Category> page = this.categoryMapper.pageQuery(categoryPageQueryDTO);

        final long total = page.getTotal();
        final List<Category> records = page.getResult();

        return new PageResult(total, records);
    }

    @Override
    public void enableDisableCategory(final Integer status, final Long id) {
        log.info("Enable or disable category: status={}, id={}", status, id);

        final Category category = Category.builder()
            .id(id)
            .status(status)
            .build();

        this.categoryMapper.update(category);
    }

    @Override
    public void deleteById(final Long id) {
        log.info("Delete by id: {}", id);

        final Integer dishesCount = this.dishMapper.countByCategoryId(id);
        if (dishesCount > 0) {
            throw new DeletionNotAllowedException(MessageConstant.CATEGORY_BE_RELATED_BY_DISH);
        }

        final Integer setMealCount = this.setMealMapper.countByCategoryId(id);
        if (setMealCount > 0) {
            throw new DeletionNotAllowedException(MessageConstant.CATEGORY_BE_RELATED_BY_SETMEAL);
        }

        this.categoryMapper.deleteById(id);
    }

    @Override
    public List<Category> getCategoryList(final Integer type) {
        log.info("Get category list by type: {}", type);

        return this.categoryMapper.findCategoryListByType(type);
    }

    @Override
    public void updateCategory(final CategoryDTO categoryDTO) {
        log.info("Update category: {}", categoryDTO);

        final Category category = new Category();

        // copy properties
        BeanUtils.copyProperties(categoryDTO, category);

        this.categoryMapper.update(category);
    }
}
