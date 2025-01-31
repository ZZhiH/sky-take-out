package com.sky.controller.admin;

import com.sky.dto.CategoryDTO;
import com.sky.result.Result;
import com.sky.service.CategoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Category controller.
 * <p>
 * Creator：ZHIHAO
 * Create date：2025/1/31 22:07
 */
@RestController
@RequestMapping("/admin/category")
@Slf4j
@Api(tags = "Category related interface")
public class CategoryController {

    /**
     * The category service.
     */
    private final CategoryService categoryService;

    /**
     * The construct with specific parameters.
     *
     * @param categoryService the CategoryService
     */
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * Create new category.
     *
     * @param categoryDTO the {@code CategoryDTO}
     * @return success
     */
    @PostMapping
    @ApiOperation("Create new category")
    public Result<Void> createCategory(@RequestBody @Valid final CategoryDTO categoryDTO) {
        log.info("Create category: {}", categoryDTO);

        this.categoryService.createCategory(categoryDTO);

        return Result.success();
    }
}
