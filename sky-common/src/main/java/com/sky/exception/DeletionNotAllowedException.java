package com.sky.exception;

/**
 * Deletion not allowed exception.
 */
public class DeletionNotAllowedException extends BaseException {

    public DeletionNotAllowedException(String msg) {
        super(msg);
    }

}
