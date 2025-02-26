package com.sky.service.admin.impl;

import com.sky.constant.StatusConstant;
import com.sky.service.admin.ShopService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * The ShopServiceImpl.
 * <p>
 * Creator：ZHIHAO
 * Create date：2025/2/22 16:52
 */
@Slf4j
public class ShopServiceImpl implements ShopService {

    /**
     * Constant SHOP_STATUS.
     */
    private static final String SHOP_STATUS = "SHOP_STATUS";

    /**
     * The redis template.
     */
    private final RedisTemplate<String, Integer> redisTemplate;

    /**
     * Constructs with specific parameters.
     *
     * @param redisTemplate the {@code RedisTemplate}
     */
    public ShopServiceImpl(final RedisTemplate<String, Integer> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void enableDisableShop(final Integer status) {
        log.info("Enable/disable shop with status: {}", status);

        final ValueOperations<String, Integer> valueOperations = redisTemplate.opsForValue();

        valueOperations.set(SHOP_STATUS, status);
    }

    @Override
    public Integer getShopStatus() {

        final ValueOperations<String, Integer> valueOperations = redisTemplate.opsForValue();
        final Integer shopStatus = valueOperations.get(SHOP_STATUS);
        log.info("get shop status: {}", StatusConstant.ENABLE.equals(shopStatus) ? "open" : "close");

        return shopStatus;
    }
}
