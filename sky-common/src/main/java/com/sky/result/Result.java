package com.sky.result;

import java.io.Serializable;

import lombok.Data;

/**
 * The back return results
 *
 * @param <T>
 */
@Data
public class Result<T> implements Serializable {

    /**
     * Code: 1 successful, 0 otherwise
     */
    private Integer code;

    /**
     * Error message.
     */
    private String msg;

    /**
     * Data.
     */
    private T data;

    public static <T> Result<T> success() {
        Result<T> result = new Result<T>();
        result.code = 1;
        return result;
    }

    public static <T> Result<T> success(T object) {
        Result<T> result = new Result<T>();
        result.data = object;
        result.code = 1;
        return result;
    }

    public static <T> Result<T> error(String msg) {
        Result result = new Result();
        result.msg = msg;
        result.code = 0;
        return result;
    }

}
