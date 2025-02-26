package com.sky.config;

import com.sky.mapper.CategoryMapper;
import com.sky.mapper.DishFlavorMapper;
import com.sky.mapper.DishMapper;
import com.sky.mapper.EmployeeMapper;
import com.sky.mapper.SetMealMapper;
import com.sky.mapper.SetmealDishMapper;
import com.sky.service.admin.CategoryService;
import com.sky.service.admin.DishService;
import com.sky.service.admin.EmployeeService;
import com.sky.service.admin.SetmealService;
import com.sky.service.admin.ShopService;
import com.sky.service.admin.impl.CategoryServiceImpl;
import com.sky.service.admin.impl.DishServiceImpl;
import com.sky.service.admin.impl.EmployeeServiceImpl;
import com.sky.service.admin.impl.SetmealServiceImpl;
import com.sky.service.admin.impl.ShopServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * The ServiceConfiguration.
 * <p>
 * Creator：ZHIHAO
 * Create date：2025/1/31 22:09
 */
@Configuration
public class ServiceConfiguration {

    /**
     * Employee service bean.
     *
     * @param employeeMapper the {@code EmployeeMapper}
     * @return EmployeeService
     */
    @Bean
    EmployeeService employeeService(final EmployeeMapper employeeMapper) {
        return new EmployeeServiceImpl(employeeMapper);
    }

    /**
     * Category service bean.
     *
     * @param categoryMapper the {@code CategoryMapper}
     * @return CategoryService
     */
    @Bean
    CategoryService categoryService(final CategoryMapper categoryMapper,
                                    final DishMapper dishMapper,
                                    final SetMealMapper setMealMapper) {
        return new CategoryServiceImpl(categoryMapper, dishMapper, setMealMapper);
    }

    /**
     * Dish service bean.
     *
     * @param dishMapper        the {@code DishMapper}
     * @param dishFlavorMapper  the {@code DishFlavorMapper}
     * @param setmealDishMapper the {@code SetmealDishMapper}
     * @return DishService
     */
    @Bean
    DishService dishService(final DishMapper dishMapper,
                            final DishFlavorMapper dishFlavorMapper,
                            final SetmealDishMapper setmealDishMapper) {
        return new DishServiceImpl(dishMapper, dishFlavorMapper, setmealDishMapper);
    }

    /**
     * Setmeal service bean.
     *
     * @param setMealMapper     the {@code SetMealMapper}
     * @param setmealDishMapper the {@code SetmealDishMapper}
     * @return SetmealService
     */
    @Bean
    SetmealService setmealService(final SetMealMapper setMealMapper,
                                  final SetmealDishMapper setmealDishMapper) {
        return new SetmealServiceImpl(setMealMapper, setmealDishMapper);
    }

    /**
     * Shop service bean.
     *
     * @param redisTemplate the {@code RedisTemplate}
     * @return ShopService
     */
    @Bean
    ShopService shopService(final RedisTemplate<String, Integer> redisTemplate) {
        return new ShopServiceImpl(redisTemplate);
    }
}
