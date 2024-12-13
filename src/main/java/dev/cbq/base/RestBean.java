package dev.cbq.base;

import org.slf4j.MDC;
import org.springframework.http.HttpStatus;

import java.util.Optional;

public record RestBean<T>(Long id, Integer code, T data, String message) {

    private static <T> RestBean<T> success() {
        return success(null);
    }

    public static <T> RestBean<T> success(T data) {
        return new RestBean<>(requestId(), HttpStatus.OK.value(), data, HttpStatus.OK.getReasonPhrase());
    }

    public static <T> RestBean<T> success(int code, T data, String message) {
        return new RestBean<>(requestId(), code, data, message);
    }

    public static <T> RestBean<T> failure(int code, String message) {
        return new RestBean<>(requestId(), code, null, message);
    }

    public static <T> RestBean<T> forbidden(String message) {
        return failure(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.getReasonPhrase());
    }

    public static <T> RestBean<T> unauthorized(String message) {
        return failure(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase());
    }


    private static long requestId() {
        String requestId = Optional.ofNullable(MDC.get("reqId")).orElse("0");
        return Long.parseLong(requestId);
    }
}
