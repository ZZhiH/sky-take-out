package com.sky.config;

import com.sky.mapper.CategoryMapper;
import com.sky.mapper.DishFlavorMapper;
import com.sky.mapper.DishMapper;
import com.sky.mapper.EmployeeMapper;
import com.sky.mapper.SetMealMapper;
import com.sky.service.CategoryService;
import com.sky.service.DishService;
import com.sky.service.EmployeeService;
import com.sky.service.impl.CategoryServiceImpl;
import com.sky.service.impl.DishServiceImpl;
import com.sky.service.impl.EmployeeServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

    @Bean
    DishService dishService(final DishMapper dishMapper,
                            final DishFlavorMapper dishFlavorMapper) {
        return new DishServiceImpl(dishMapper, dishFlavorMapper);
    }
}
