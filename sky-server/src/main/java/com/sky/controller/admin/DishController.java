package com.sky.controller.admin;

import java.util.List;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.DishService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The DishController.
 * <p>
 * Creator：ZHIHAO
 * Create date：2025/2/4 21:55
 */
@RestController
@Slf4j
@RequestMapping("/admin/dish")
@Api(tags = "Dish related interface")
public class DishController {

    /**
     * The dish service.
     */
    private final DishService dishService;

    /**
     * Constructs with specific parameters.
     *
     * @param dishService the {@code DishService}
     */
    public DishController(final DishService dishService) {
        this.dishService = dishService;
    }

    /**
     * Create new dish.
     */
    @PostMapping
    @ApiOperation("Create new dish")
    public Result<Void> save(@RequestBody @Valid final DishDTO dishDTO) {
        log.info("Create new dish: {}", dishDTO);

        this.dishService.saveWithFlavor(dishDTO);

        return Result.success();
    }

    /**
     * Find by id.
     */
    @GetMapping("/{id}")
    @ApiOperation("Find by id")
    public Result<DishDTO> findById(@PathVariable final Long id) {
        log.info("Find by id: {}", id);

        final DishDTO dishDTO = this.dishService.findById(id);

        return Result.success(dishDTO);
    }

    /**
     * Find by categoryId.
     *
     * @return list of {@code Dish} with given categoryId
     */
    @GetMapping("/list")
    @ApiOperation("Find by category id")
    public Result<List<Dish>> findByCategoryId(@RequestParam final String categoryId) {
        log.info("Find by category categoryId: {}", categoryId);

        final List<Dish> dishList = this.dishService.findByCategoryId(categoryId);

        return Result.success(dishList);
    }

    /**
     * Dish page query.
     *
     * @param dishPageQueryDTO the {@code DishPageQueryDTO}
     * @return result of {@code PageResult}
     */
    @GetMapping("/page")
    @ApiOperation("Dish page query")
    public Result<PageResult> page(@Valid final DishPageQueryDTO dishPageQueryDTO) {
        log.info("Dish page query: {}", dishPageQueryDTO);

        final PageResult pageResult = this.dishService.pageQuery(dishPageQueryDTO);

        return Result.success(pageResult);
    }

    /**
     * Enable/disable dish by status and id.
     *
     * @param status the dish status
     * @param dishId the dish id
     */
    @PostMapping("/status/{status}")
    @ApiOperation(value = "Enable/disable dish")
    public Result<Void> enableOrDisableDish(@PathVariable("status") final Integer status,
                                            @RequestParam("id") final Long dishId) {
        log.info("Enable/disable dish: status={}, dishId={}", status, dishId);

        this.dishService.enableDisableDish(status, dishId);

        return Result.success();
    }

    /**
     * Update dish by id.
     */
    @PutMapping
    @ApiOperation(value = "Update dish by id")
    public Result<Void> updateDish(@RequestBody @Valid final DishDTO dishDTO) {
        log.info("Update dish: {}", dishDTO);

        this.dishService.updateDish(dishDTO);

        return Result.success();
    }
}
