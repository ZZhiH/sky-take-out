package com.sky.controller.admin;

import java.util.List;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.admin.CategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
@Tag(name = "Category related interface")
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
    public CategoryController(final CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * Create new category.
     *
     * @param categoryDTO the {@code CategoryDTO}
     * @return success
     */
    @PostMapping
    @Operation(summary = "createCategory", description = "Create new category")
    public Result<Void> createCategory(@RequestBody @Valid final CategoryDTO categoryDTO) {
        log.info("Create category: {}", categoryDTO);

        this.categoryService.createCategory(categoryDTO);

        return Result.success();
    }

    /**
     * Category page query.
     *
     * @param categoryPageQueryDTO the {@code CategoryPageQueryDTO}
     * @return the result of {@code PageResult}
     */
    @GetMapping("/page")
    @Operation(summary = "pageQuery", description = "Category page query")
    public Result<PageResult> page(final CategoryPageQueryDTO categoryPageQueryDTO) {
        log.info("Find category: {}", categoryPageQueryDTO);

        final PageResult pageResult = this.categoryService.pageQuery(categoryPageQueryDTO);

        return Result.success(pageResult);
    }

    /**
     * Enable/disable employee category.
     */
    @PostMapping("/status/{status}")
    @Operation(summary = "enableOrDisableCategory", description = "Enable/disable category")
    public Result<Void> enableOrDisableCategory(@PathVariable("status") final Integer status,
                                                @RequestParam(value = "id") final Long id) {
        log.info("Enable/disable category: status={}, id={}", status, id);

        this.categoryService.enableDisableCategory(status, id);

        return Result.success();
    }

    /**
     * Delete category by id.
     *
     * @param id the category id
     */
    @DeleteMapping
    @Operation(summary = "deleteCategory", description = "Delete category by id")
    public Result<Void> deleteCategory(@RequestParam(value = "id") final Long id) {
        log.info("Delete category: {}", id);

        this.categoryService.deleteById(id);

        return Result.success();
    }

    /**
     * Get category list by type.
     *
     * @param type the category type
     * @return list of {@code Category}
     */
    @GetMapping("/list")
    @Operation(summary = "getCategoryList", description = "get category list")
    public Result<List<Category>> getCategoryList(@RequestParam(value = "type", required = false) final Integer type) {
        log.info("Get category list by type: {}", type);

        final List<Category> categories = this.categoryService.getCategoryList(type);

        return Result.success(categories);
    }

    /**
     * Update category.
     *
     * @param categoryDTO the {@code CategoryDTO}
     */
    @PutMapping
    @Operation(summary = "updateCategory", description = "update category")
    public Result<Void> updateCategory(@RequestBody @Valid final CategoryDTO categoryDTO) {
        log.info("Update category: {}", categoryDTO);

        this.categoryService.updateCategory(categoryDTO);

        return Result.success();
    }
}
