package com.sky.service.impl;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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

    @Override
    public void enableDisableSetmeal(final Integer status, final Long setmealId) {
        log.info("Enable/disable setmeal: status={}, setmealId={}", status, setmealId);

        final Setmeal setmeal = Setmeal.builder()
            .id(setmealId)
            .status(status)
            .build();

        this.setMealMapper.update(setmeal);
    }

    @Override
    public SetmealVO findById(final Long id) {
        log.info("Find setmeal by id: {}", id);

        final SetmealVO setmealVO = new SetmealVO();

        // find setmeal
        final Setmeal setmeal = this.setMealMapper.findById(id);

        // copy properties
        BeanUtils.copyProperties(setmeal, setmealVO);

        // find setmeal dishes
        final List<SetmealDish> setmealDishes = this.setmealDishMapper.findBySetmealId(id);
        setmealVO.setSetmealDishes(setmealDishes);

        return setmealVO;
    }

    @Override
    @Transactional
    public void updateWithDishes(final SetmealDTO setmealDTO) {
        log.info("update with dishes: {}", setmealDTO);

        final Setmeal setmeal = new Setmeal();

        // copy properties
        BeanUtils.copyProperties(setmealDTO, setmeal);

        this.setMealMapper.update(setmeal);

        final Long setmealId = setmealDTO.getId();
        final List<SetmealDish> setmealDishes = setmealDTO.getSetmealDishes();
        final List<SetmealDish> savedDishes = this.setmealDishMapper.findBySetmealId(setmealId);

        final Map<String, SetmealDish> dishesMap = setmealDishes.stream().collect(Collectors.toMap(SetmealDish::getName,
            Function.identity(), (a, b) -> b));
        final Map<String, SetmealDish> savedDishesMap =
            savedDishes.stream().collect(Collectors.toMap(SetmealDish::getName,
                Function.identity(), (a, b) -> b));

        final List<Long> idsToDelete =
            savedDishes.stream().filter(d -> !dishesMap.containsKey(d.getName())).map(SetmealDish::getId).toList();

        if (!idsToDelete.isEmpty()) {
            // delete dishes
            this.setmealDishMapper.deleteAllByIds(idsToDelete);
        }

        setmealDishes
            .forEach(d -> {
                final String name = d.getName();
                if (savedDishesMap.containsKey(name)) {
                    // update dishes
                    final SetmealDish setmealDish = savedDishesMap.get(name);
                    setmealDish.setCopies(d.getCopies());
                    this.setmealDishMapper.update(setmealDish);
                } else {
                    // insert new dishes
                    d.setSetmealId(setmealId);
                    this.setmealDishMapper.insert(d);
                }
            });
    }
}
