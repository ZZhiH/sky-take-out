package com.sky.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "sky.jwt")
@Data
public class JwtProperties {

    /**
     * Service settings for jwt token.
     */
    private String adminSecretKey;
    private long adminTtl;
    private String adminTokenName;

    /**
     * User setting for jwt token.
     */
    private String userSecretKey;
    private long userTtl;
    private String userTokenName;

}
