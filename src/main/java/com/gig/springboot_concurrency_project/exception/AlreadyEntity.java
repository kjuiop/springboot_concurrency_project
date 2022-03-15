package com.gig.springboot_concurrency_project.exception;

/**
 * @author : Jake
 * @date : 2022-03-15
 */
public class AlreadyEntity extends RuntimeException {

    public AlreadyEntity() {
    }

    public AlreadyEntity(String message) { super(message); }

    public AlreadyEntity(String message, Throwable cause) {
        super(message, cause);
    }

    public AlreadyEntity(Throwable cause) {
        super(cause);
    }

    public AlreadyEntity(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
