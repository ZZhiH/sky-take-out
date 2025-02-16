package com.sky.controller.admin;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.SetmealService;
import com.sky.vo.SetmealVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
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
 * The SetmealController.
 * <p>
 * Creator：ZHIHAO
 * Create date：2025/2/15 21:52
 */
@RestController
@Slf4j
@RequestMapping("/admin/setmeal")
@Tag(name = "Setmeal related interface")
public class SetmealController {

    /**
     * The setmeal service.
     */
    private final SetmealService setmealService;

    /**
     * Constructs with specific parameters.
     *
     * @param setmealService the {@code SetmealService}
     */
    public SetmealController(final SetmealService setmealService) {
        this.setmealService = setmealService;
    }

    /**
     * Create new setmeal.
     *
     * @param setmealDTO the {@code SetmealDTO}
     */
    @PostMapping
    @Operation(summary = "createSetmeal", description = "Create new setmeal")
    public Result<Void> save(@RequestBody @Valid final SetmealDTO setmealDTO) {
        log.info("Create new setmeal: {}", setmealDTO);

        this.setmealService.save(setmealDTO);

        return Result.success();
    }

    /**
     * Setmeal page query.
     *
     * @return the {@code PageResult}
     */
    @GetMapping("/page")
    @Operation(summary = "setmealPageQuery", description = "Setmeal page query")
    public Result<PageResult> pageQuery(@Valid final SetmealPageQueryDTO pageQueryDTO) {
        log.info("Setmeal page query: {}", pageQueryDTO);

        final PageResult pageResult = this.setmealService.pageQuery(pageQueryDTO);

        return Result.success(pageResult);
    }

    /**
     * Enable/disable setmeal by status
     *
     * @param status the setmeal status
     * @return the setmeal id
     */
    @PostMapping("/status/{status}")
    @Operation(summary = "enableDisableSetmeal", description = "Enable/disable setmeal")
    public Result<Void> enableDisableStatus(@PathVariable("status") final Integer status,
                                            @RequestParam("id") final Long setmealId) {
        log.info("Enable/disable setmeal: status={}, setmealId={}", status, setmealId);

        this.setmealService.enableDisableSetmeal(status, setmealId);

        return Result.success();
    }

    /**
     * Find setmeal by id.
     *
     * @return the {@code SetmealVO}
     */
    @GetMapping("/{id}")
    @Operation(summary = "findById", description = "find setmeal by id")
    public Result<SetmealVO> findById(@PathVariable("id") final Long id) {
        log.info("find setmeal by id: {}", id);

        final SetmealVO setmealVO = this.setmealService.findById(id);

        return Result.success(setmealVO);
    }

    /**
     * Update with dishes.
     *
     * @param setmealDTO the {@code SetmealDish}
     */
    @PutMapping
    @Operation(summary = "updateWithDishes", description = "Update setmeal dish with dishes")
    public Result<Void> updateWithDishes(@RequestBody @Valid final SetmealDTO setmealDTO) {
        log.info("Update setmeal dish with dishes: {}", setmealDTO);

        this.setmealService.updateWithDishes(setmealDTO);

        return Result.success();
    }
}
