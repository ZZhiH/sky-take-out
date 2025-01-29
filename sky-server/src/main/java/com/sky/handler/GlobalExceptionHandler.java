package com.sky.handler;

import java.sql.SQLIntegrityConstraintViolationException;

import com.sky.constant.MessageConstant;
import com.sky.exception.BaseException;
import com.sky.result.Result;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global Exception Handler to handle business exceptions thrown in the project
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * Handler business exception.
     *
     * @param ex the exception
     * @return the Result
     */
    @ExceptionHandler
    public Result exceptionHandler(BaseException ex) {
        log.error("Exception info：{}", ex.getMessage());
        return Result.error(ex.getMessage());
    }

    /**
     * Handler sql exception.
     *
     * @param exception the exception
     * @return the Result
     */
    @ExceptionHandler
    public Result exceptionHandler(final SQLIntegrityConstraintViolationException exception) {
        String message = exception.getMessage();
        log.error("Error inf: {}", message);

        if (message.contains("Duplicate entry")) {
            String[] split = message.split(" ");
            String username = split[2];
            String msg = username + " " + MessageConstant.ALREADY_EXISTS;
            return Result.error(msg);
        }
        
        return Result.error(MessageConstant.UNKNOWN_ERROR);
    }
}
