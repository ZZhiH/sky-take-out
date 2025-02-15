package com.sky.controller.admin;

import java.io.IOException;
import java.util.UUID;

import com.sky.constant.MessageConstant;
import com.sky.result.Result;
import com.sky.utils.S3Util;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * The CommonController.
 * <p>
 * Creator：ZHIHAO
 * Create date：2025/2/12 21:42
 */
@RestController
@Slf4j
@RequestMapping("/admin/common")
@Tag(name = "Common interface")
public class CommonController {

    @Autowired
    private S3Util s3Util;

    /**
     * Common uploader.
     *
     * @param file the upload file
     * @return
     */
    @PostMapping("/upload")
    @Operation(summary = "fileUploader", description = "Common file uploader")
    public Result<String> upload(final MultipartFile file) {
        log.info("File uploader: {}", file);

        try {
            // original file name
            final String originalFilename = file.getOriginalFilename();
            // get original file suffix
            final String extension = originalFilename.substring(originalFilename.lastIndexOf("."));

            // new file name
            final String objectName = UUID.randomUUID() + extension;

            final String filePath = this.s3Util.upload(file.getBytes(), objectName);
            return Result.success(filePath);
        } catch (final IOException e) {
            log.error("Error upload: {}", e.getMessage(), e);
            return Result.error(MessageConstant.UPLOAD_FAILED);
        }
    }
}
