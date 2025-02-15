package com.sky.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * The AmazonS3Properties.
 * <p>
 * Creator：ZHIHAO
 * Create date：2025/2/12 22:24
 */
@Component
@ConfigurationProperties(prefix = "aws.s3")
@Data
public class AmazonS3Properties {

    private String endpoint;

    private String bucketName;

    private String region;

    private String accessKey;

    private String secretKey;
}
