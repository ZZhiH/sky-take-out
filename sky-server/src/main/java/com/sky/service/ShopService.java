package com.sky.service;

/**
 * The ShopService interface.
 * <p>
 * Creator：ZHIHAO
 * Create date：2025/2/22 16:52
 */
public interface ShopService {

    /**
     * Enable/disable shop with given status.
     *
     * @param status the status, 1 enable, 0 disable
     */
    void enableDisableShop(Integer status);

    /**
     * Get shop status.
     *
     * @return status, 1 enable, 0 disable
     */
    Integer getShopStatus();
}
