package com.sky.handler;

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

}
