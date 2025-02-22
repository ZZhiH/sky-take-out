package com.sky.controller.admin;

import com.sky.result.Result;
import com.sky.service.ShopService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The ShopController.
 * <p>
 * Creator：ZHIHAO
 * Create date：2025/2/22 16:48
 */
@RestController
@RequestMapping("/admin/shop")
@Slf4j
@Tag(name = "Shop related interface")
public class AdminShopController {

    /**
     * The shop service.
     */
    private final ShopService shopService;

    /**
     * The construct with specific parameters.
     *
     * @param shopService the ShopController
     */
    public AdminShopController(final ShopService shopService) {
        this.shopService = shopService;
    }

    /**
     * Update shop status.
     *
     * @param status the status, 1 enable, 0 disable
     */
    @PutMapping("/{status}")
    @Operation(summary = "EnableDisableShop", description = "Enable/disable shop")
    public Result<Void> EnableDisableShop(@PathVariable("status") final Integer status) {
        log.info("Enable/disable shop: {}", status);

        this.shopService.enableDisableShop(status);

        return Result.success();
    }

    /**
     * Get shop status.
     *
     * @return status, 1 enable, 0 disable
     */
    @GetMapping("/status")
    @Operation(summary = "getShopStatus", description = "Get shop status")
    public Result<Integer> status() {
        log.info("Get shop status");

        final Integer status = this.shopService.getShopStatus();

        return Result.success(status);
    }
}
