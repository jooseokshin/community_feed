package org.community.common.domain.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    INVALID_INPUT_VALUE(400, "invalid input value"),
    NOT_FOUND(404, "note found data"),
    INTERNAL_ERROR(500, "unexpected error");

    private final Integer code;
    private final String message;

    ErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
