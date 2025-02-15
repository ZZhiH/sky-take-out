package com.sky.utils;

import com.sky.properties.AmazonS3Properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

/**
 * The S3Util.
 * <p>
 * Creator：ZHIHAO
 * Create date：2025/2/12 22:35
 */
@Data
@AllArgsConstructor
@Slf4j
public class S3Util {

    private AmazonS3Properties properties;

    private S3Client s3Client;

    /**
     * File uploader
     *
     * @param bytes
     * @param objectName
     * @return
     */
    public String upload(final byte[] bytes, final String objectName) {

        final PutObjectRequest putObjectRequest = PutObjectRequest.builder()
            .bucket(this.properties.getBucketName())
            .key(objectName)
            .build();
        this.s3Client.putObject(putObjectRequest, RequestBody.fromBytes(bytes));

        // https://your-bucket-name.s3.amazonaws.com/your-file-name
        final StringBuilder stringBuilder = new StringBuilder("https://");
        stringBuilder
            .append(this.properties.getBucketName())
            .append(".")
            .append(this.properties.getEndpoint())
            .append("/")
            .append(objectName);

        log.info("File upload to:{}", stringBuilder);

        return stringBuilder.toString();
    }
}
