package com.sky.controller.admin;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.SetmealService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
