package com.sky.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "sky.wechat")
@Data
public class WeChatProperties {

    /**
     * app id.
     */
    private String appid;

    /**
     * app secret.
     */
    private String secret;

    /**
     * Merchant id.
     */
    private String merchantId;

    /**
     * Merchant API serial number.
     */
    private String merchantSerialNo;

    /**
     * Private key file path.
     */
    private String privateKeyFilePath;

    /**
     * Certificate api key.
     */
    private String apiV3Key;

    /**
     * WeChat certificate.
     */
    private String weChatPayCertFilePath;

    /**
     * Callback address for successful payment.
     */
    private String notifyUrl;

    /**
     * Callback address for successful refund.
     */
    private String refundNotifyUrl;

}
