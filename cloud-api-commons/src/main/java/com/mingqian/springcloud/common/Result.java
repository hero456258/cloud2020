package com.mingqian.springcloud.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.function.Consumer;

/**
 * @Author: mingqian
 * @DATE: 2020/4/3 14:02
 */
@ToString
@Getter
@Setter
@Builder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 5754271999306704983L;

    public static final int OK = 0;

    private int code;
    private String message;
    private T data;

    @Builder.Default
    private Long timestamp = System.currentTimeMillis();

    public static <T> Result<T> ok(T data, String message) {
        return Result.<T>builder()
                .code(OK)
                .data(data)
                .message(message)
                .build();
    }

    public static <T> Result<T> ok(T data) {
        return Result.<T>builder()
                .code(OK)
                .data(data)
                .message("ok")
                .build();
    }

    public static <T> Result<T> ok() {
        return Result.<T>builder()
                .code(OK)
                .message("ok")
                .build();
    }

    public static <T> Result<T> fail(int code) {
        return Result.<T>builder()
                .code(code)
                .message("failed")
                .build();
    }

    public static <T> Result<T> fail(int code, String message) {
        return Result.<T>builder()
                .code(code)
                .message(message)
                .build();
    }

    @JsonIgnore
    public boolean isOk() {
        return OK == this.code || 200 == this.code;
    }

    public void ifOk(Consumer<? super T> action) {
        if (isOk() && this.data != null) {
            action.accept(this.data);
        }
    }
}
