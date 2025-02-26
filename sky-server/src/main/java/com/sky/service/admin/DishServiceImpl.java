package com.sky.service.admin.impl;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.constant.MessageConstant;
import com.sky.constant.StatusConstant;
import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.entity.DishFlavor;
import com.sky.exception.DeletionNotAllowedException;
import com.sky.mapper.DishFlavorMapper;
import com.sky.mapper.DishMapper;
import com.sky.mapper.SetmealDishMapper;
import com.sky.result.PageResult;
import com.sky.service.admin.DishService;
import com.sky.vo.DishVO;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

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
     * The setmeal mapper.
     */
    private final SetmealDishMapper setmealDishMapper;

    /**
     * Constructs with specific parameters.
     *
     * @param dishMapper        the {@code DishMapper}
     * @param dishFlavorMapper  the {@code DishFlavorMapper}
     * @param setmealDishMapper the {@code SetmealDishMapper}
     */
    public DishServiceImpl(final DishMapper dishMapper,
                           final DishFlavorMapper dishFlavorMapper,
                           final SetmealDishMapper setmealDishMapper) {
        this.dishMapper = dishMapper;
        this.dishFlavorMapper = dishFlavorMapper;
        this.setmealDishMapper = setmealDishMapper;
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
    public DishVO findById(final Long id) {
        log.info("find by id: {}", id);

        final DishVO dishVo = new DishVO();

        // find dish by id
        final DishVO dish = this.dishMapper.findByIdWithFlavor(id);

        if (dish == null) {
            return dishVo;
        }

        // copy properties
        BeanUtils.copyProperties(dish, dishVo);

        // find dish flavor by id
        final List<DishFlavor> dishFlavors = this.dishFlavorMapper.findByDishId(id);

        // set dish flavors
        dishVo.setFlavors(dishFlavors);

        return dishVo;
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

        final Page<DishVO> page = this.dishMapper.pageQuery(dishPageQueryDTO);

        final long total = page.getTotal();
        final List<DishVO> records = page.getResult();

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
    public void updateWithFlavors(final DishDTO dishDTO) {
        log.info("Update dish: {}", dishDTO);

        final Dish dish = new Dish();

        // copy properties
        BeanUtils.copyProperties(dishDTO, dish);

        this.dishMapper.update(dish);

        final List<DishFlavor> flavors = dishDTO.getFlavors();
        final List<DishFlavor> savedFlavors = this.dishFlavorMapper.findByDishId(dishDTO.getId());

        final Map<String, DishFlavor> dishFlavorMap = flavors.stream()
            .collect(Collectors.toMap(DishFlavor::getName, Function.identity()));

        final Map<String, DishFlavor> savedDishFlavorMap = savedFlavors.stream()
            .collect(Collectors.toMap(DishFlavor::getName, Function.identity()));

        final List<Long> idList =
            savedFlavors.stream()
                .filter(f -> !dishFlavorMap.containsKey(f.getName()))
                .map(DishFlavor::getId)
                .toList();

        if (!CollectionUtils.isEmpty(idList)) {
            // delete flavors
            this.dishFlavorMapper.deleteAllById(idList);
        }


        if (!CollectionUtils.isEmpty(flavors)) {
            flavors.forEach(f -> {
                if (savedDishFlavorMap.containsKey(f.getName())) {
                    // update flavors
                    final DishFlavor dishFlavor = savedDishFlavorMap.get(f.getName());
                    dishFlavor.setValue(f.getValue());
                    this.dishFlavorMapper.update(dishFlavor);
                } else {
                    // new flavors
                    f.setDishId(dish.getId());
                    this.dishFlavorMapper.insert(f);
                }
            });
        }
    }

    @Override
    @Transactional
    public void deleteBatch(final List<Long> ids) {
        log.info("Batch delete dishes by ids: {}", ids);

        final List<Dish> dishes = this.dishMapper.findByIds(ids);

        if (dishes.stream().anyMatch(dish -> StatusConstant.ENABLE.equals(dish.getStatus()))) {
            // cant delete when dish is on sale
            throw new DeletionNotAllowedException(MessageConstant.DISH_ON_SALE);
        }

        final int count = this.setmealDishMapper.countByDishIds(ids);
        if (count > 0) {
            // cant delete when dish is related by setmeal
            throw new DeletionNotAllowedException(MessageConstant.DISH_BE_RELATED_BY_SET_MEAL);
        }

        final List<DishFlavor> dishFlavors = this.dishFlavorMapper.findByDishIdIn(ids);

        if (!dishFlavors.isEmpty()) {
            this.dishFlavorMapper.deleteAllByDishIds(ids);
        }

        this.dishMapper.deleteAll(ids);
    }
}
