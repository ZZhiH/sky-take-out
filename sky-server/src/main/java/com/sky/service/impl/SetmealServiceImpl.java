package com.sky.service.impl;

import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.constant.StatusConstant;
import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.entity.SetmealDish;
import com.sky.mapper.SetMealMapper;
import com.sky.mapper.SetmealDishMapper;
import com.sky.result.PageResult;
import com.sky.service.SetmealService;
import com.sky.vo.SetmealVO;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;

/**
 * The SetmealServiceImpl.
 * <p>
 * Creator：ZHIHAO
 * Create date：2025/2/15 21:55
 */
@Slf4j
public class SetmealServiceImpl implements SetmealService {

    /**
     * The setmeal mapper.
     */
    private final SetMealMapper setMealMapper;

    /**
     * The setmeal dish mapper.
     */
    private final SetmealDishMapper setmealDishMapper;

    /**
     * Constructs with specific parameters.
     *
     * @param setMealMapper     the {@code SetMealMapper}
     * @param setmealDishMapper the {@code SetmealDishMapper}
     */
    public SetmealServiceImpl(final SetMealMapper setMealMapper,
                              final SetmealDishMapper setmealDishMapper) {
        this.setMealMapper = setMealMapper;
        this.setmealDishMapper = setmealDishMapper;
    }

    @Override
    @Transactional
    public void save(final SetmealDTO setmealDTO) {
        log.info("create new setmeal {}", setmealDTO);

        // create setmeal
        final Setmeal setmeal = new Setmeal();

        // copy properties
        BeanUtils.copyProperties(setmealDTO, setmeal);
        setmeal.setStatus(StatusConstant.ENABLE);

        // insert setmeal
        this.setMealMapper.insert(setmeal);

        // insert setmeal dishes
        final List<SetmealDish> setmealDishes = setmealDTO.getSetmealDishes();
        setmealDishes.forEach(sd -> sd.setSetmealId(setmeal.getId()));
        this.setmealDishMapper.insertAll(setmealDishes);
    }

    @Override
    public PageResult pageQuery(final SetmealPageQueryDTO pageQueryDTO) {
        log.info("Page query: {}", pageQueryDTO);

        PageHelper.startPage(pageQueryDTO.getPage(), pageQueryDTO.getPageSize());

        final Page<SetmealVO> page = this.setMealMapper.pageQuery(pageQueryDTO);

        final long total = page.getTotal();
        final List<SetmealVO> records = page.getResult();

        return new PageResult(total, records);
    }
}
