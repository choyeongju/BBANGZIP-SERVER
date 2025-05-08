package org.sopt.auth.exception;

import lombok.Getter;
import org.sopt.code.ErrorCode;
import org.springframework.http.HttpStatus;

@Getter
public enum AuthErrorCode implements ErrorCode {
    // 400
    INVALID_ARGUMENTS(HttpStatus.BAD_REQUEST, 400, "인자의 형식이 올바르지 않습니다."),
    WRONG_ENTRY_POINT(HttpStatus.BAD_REQUEST, 400, "잘못된 요청입니다."),
    MALFORMED_JWT_TOKEN(HttpStatus.BAD_REQUEST, 400, "잘못된 형식의 토큰입니다."),
    TYPE_ERROR_JWT_TOKEN(HttpStatus.BAD_REQUEST, 400, "올바른 타입의 JWT 토큰이 아닙니다."),
    UNSUPPORTED_JWT_TOKEN(HttpStatus.BAD_REQUEST, 401, "지원하지 않는 형식의 토큰입니다."),

    // 401
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, 401, "인증되지 않은 사용자입니다."),
    EXPIRED_JWT_TOKEN(HttpStatus.UNAUTHORIZED, 401, "만료된 토큰입니다."),
    EXPIRED_REFRESH_TOKEN(HttpStatus.UNAUTHORIZED, 401, "유효하지 않은 리프레시 토큰입니다."),
    UNKNOWN_JWT_TOKEN(HttpStatus.UNAUTHORIZED, 401, "알 수 없는 인증 토큰 오류가 발생했습니다."),


    // 500
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 500, "서버 내부 오류입니다."),
    ;

    public final HttpStatus httpStatus;
    private final int code;
    private final String message;

    AuthErrorCode(HttpStatus httpStatus, int code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }

    @Override
    public HttpStatus getHttpStatus(){
        return httpStatus;
    }

    @Override
    public int getCode(){
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

