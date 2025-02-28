package com.dhs.modeKasu.infrastructure.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    INVALID_LOGIN_ID(CONFLICT, "로그인 실패 입니다.", "login_id: %s"),
    MEMBER_NOT_FOUND(CONFLICT, "없는 회원 입니다.", "login_id: %s"),
    DUPLICATE_LOGIN_ID(CONFLICT, "이미 존재한 아이디 입니다.", "login_id: %s"),
    INVALID_PASSWORD(CONFLICT, "비번 확인해주세요.","비번이 일치하지 않음"),
    UNAUTHORIZED_ACCESS(UNAUTHORIZED, "회원 인증 실패입니다.","인증되지 않은 접근 입니다."),
    INVALID_MEMBER(CONFLICT, "존재하지 않는 유저입니다.", "member_id: %d"),
    INVALID_CATEGORY(CONFLICT, "존재하지 않는 카테고리입니다.", "category_id: %d"),
    INVALID_PAYMENT_SERVICE(CONFLICT, "존재하지 결제서비스 타입 입니다.", "payment_provider: %s");


    private final HttpStatus httpStatus;
    private final String message;
    private final String reason;

    public ApplicationException build(Object ...args) {
        return new ApplicationException(httpStatus, message, reason.formatted(args));
    }
}
