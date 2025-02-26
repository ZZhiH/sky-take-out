package com.sky.controller.user;

import com.sky.result.Result;
import com.sky.service.admin.ShopService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The ShopController.
 * <p>
 * Creator：ZHIHAO
 * Create date：2025/2/22 17:07
 */
@RestController
@RequestMapping("/user/shop")
@Slf4j
@Tag(name = "User shop related interface")
public class UserShopController {

    /**
     * The shop service.
     */
    private final ShopService shopService;

    /**
     * Constructs with specific parameters.
     *
     * @param shopService the {@code ShopService}
     */
    public UserShopController(final ShopService shopService) {
        this.shopService = shopService;
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
