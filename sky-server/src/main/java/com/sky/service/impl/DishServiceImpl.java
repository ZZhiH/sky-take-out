package com.sky.service.impl;

import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.constant.StatusConstant;
import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.entity.DishFlavor;
import com.sky.mapper.DishFlavorMapper;
import com.sky.mapper.DishMapper;
import com.sky.result.PageResult;
import com.sky.service.DishService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;

/**
 * The DishServiceImpl.
 * <p>
 * Creator：ZHIHAO
 * Create date：2025/2/4 22:01
 */
@Slf4j
public class DishServiceImpl implements DishService {

    /**
     * The dish mapper.
     */
    private final DishMapper dishMapper;

    /**
     * The dish flavor mapper.
     */
    private final DishFlavorMapper dishFlavorMapper;

    /**
     * Constructs with specific parameters.
     *
     * @param dishMapper       the {@code DishMapper}
     * @param dishFlavorMapper the {@code DishFlavorMapper}
     */
    public DishServiceImpl(final DishMapper dishMapper,
                           final DishFlavorMapper dishFlavorMapper) {
        this.dishMapper = dishMapper;
        this.dishFlavorMapper = dishFlavorMapper;
    }

    @Override
    @Transactional
    public void saveWithFlavor(final DishDTO dishDTO) {
        log.info("create new dish: {}", dishDTO);

        final Dish dish = new Dish();

        // copy properties
        BeanUtils.copyProperties(dishDTO, dish);

        // set status
        dish.setStatus(StatusConstant.ENABLE);

        // create new dish
        this.dishMapper.insert(dish);

        // create new dish flavor
        final List<DishFlavor> flavors = dishDTO.getFlavors();
        flavors.forEach(f -> f.setDishId(dish.getId()));
        this.dishFlavorMapper.insertBatch(flavors);
    }

    @Override
    public DishDTO findById(final Long id) {
        log.info("find by id: {}", id);

        final DishDTO dishDTO = new DishDTO();

        // find dish by id
        final Dish dish = this.dishMapper.findById(id);

        if (dish == null) {
            return dishDTO;
        }

        // copy properties
        BeanUtils.copyProperties(dish, dishDTO);

        // find dish flavor by id
        final List<DishFlavor> dishFlavors = this.dishFlavorMapper.findByDishId(id);

        // set dish flavors
        dishDTO.setFlavors(dishFlavors);

        return dishDTO;
    }

    @Override
    public List<Dish> findByCategoryId(final String categoryId) {
        log.info("find by category id: {}", categoryId);

        return this.dishMapper.findByCategoryId(categoryId);
    }

    @Override
    public PageResult pageQuery(final DishPageQueryDTO dishPageQueryDTO) {
        log.info("dish page query: {}", dishPageQueryDTO);

        PageHelper.startPage(dishPageQueryDTO.getPage(), dishPageQueryDTO.getPageSize());

        final Page<Dish> page = this.dishMapper.pageQuery(dishPageQueryDTO);

        final long total = page.getTotal();
        final List<Dish> records = page.getResult();

        return new PageResult(total, records);
    }

    @Override
    public void enableDisableDish(final Integer status, final Long dishId) {
        log.info("Enable/disable dish: status={}, dishId={}", status, dishId);

        final Dish dish = Dish.builder()
            .id(dishId)
            .status(status)
            .build();

        this.dishMapper.update(dish);
    }

    @Override
    @Transactional
    public void updateDish(final DishDTO dishDTO) {
        log.info("Update dish: {}", dishDTO);

        final Dish dish = new Dish();

        // copy properties
        BeanUtils.copyProperties(dishDTO, dish);

        final List<DishFlavor> flavors = dishDTO.getFlavors();

        this.dishMapper.update(dish);
        this.dishFlavorMapper.updateBatch(flavors);
    }
}
