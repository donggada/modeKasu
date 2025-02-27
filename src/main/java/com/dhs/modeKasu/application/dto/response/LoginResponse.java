package com.dhs.modeKasu.application.dto.response;


import com.dhs.modeKasu.domain.model.member.Member;

public record LoginResponse(
        String loginId,
        String username,
        String phoneNumber,
        String message
) {
    public static LoginResponse of (Member member) {
        return new LoginResponse(
                member.getLoginId(),
                member.getUsername(),
                member.getPhoneNumber(),
                "로그인 성공"
        );
    }
}
