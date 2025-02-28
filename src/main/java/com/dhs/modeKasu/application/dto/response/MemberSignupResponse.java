package com.dhs.modeKasu.application.dto.response;


import com.dhs.modeKasu.domain.model.member.Member;

public record MemberSignupResponse(
        Long id,
        String username,
        String message
) {

    public static MemberSignupResponse of (Member member) {
        return new MemberSignupResponse(
                member.getId(),
                member.getUsername(),
                "회원가입 성공"
        );
    }

}
