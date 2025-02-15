package com.sky.config;

import com.sky.properties.AmazonS3Properties;
import com.sky.utils.S3Util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

/**
 * The AwsS3Config.
 * <p>
 * Creator：ZHIHAO
 * Create date：2025/2/12 22:14
 */
@Configuration
@Slf4j
public class AwsS3Config {

    @Bean
    @ConditionalOnMissingBean
    S3Util s3Util(final AmazonS3Properties properties) {
        log.info("start aws s3 configuration: {}", properties);
        final StaticCredentialsProvider staticCredentialsProvider =
            this.awsCredentialsProvider(properties.getAccessKey(), properties.getSecretKey());
        final S3Client s3Client = this.s3Client(staticCredentialsProvider, properties.getRegion());
        return new S3Util(properties, s3Client);
    }

    private StaticCredentialsProvider awsCredentialsProvider(final String accessKey, final String secretKey) {
        final AwsCredentials awsCredentials = AwsBasicCredentials
            .create(accessKey, secretKey);
        return StaticCredentialsProvider.create(awsCredentials);
    }

    private S3Client s3Client(final StaticCredentialsProvider staticCredentialsProvider, final String region) {
        return S3Client.builder()
            .credentialsProvider(staticCredentialsProvider)
            .region(Region.of(region))
            .build();
    }
}
