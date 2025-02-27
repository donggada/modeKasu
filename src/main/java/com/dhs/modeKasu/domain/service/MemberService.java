package com.dhs.modeKasu.domain.service;


import com.dhs.modeKasu.application.dto.request.LoginRequest;
import com.dhs.modeKasu.application.dto.request.MemberSignupRequest;
import com.dhs.modeKasu.domain.model.member.Member;
import com.dhs.modeKasu.domain.model.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.dhs.modeKasu.infrastructure.exception.ErrorCode.INVALID_LOGIN_ID;
import static com.dhs.modeKasu.infrastructure.exception.ErrorCode.INVALID_MEMBER;


@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member saveMember(MemberSignupRequest request) {
        return memberRepository.save(Member.createMember(request));
    }

    public Member authenticateMember(LoginRequest request) {
        return memberRepository.findByLoginIdAndPassword(request.login(), request.password())
                .orElseThrow(() -> INVALID_LOGIN_ID.build(request.login()));
    }

    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(() -> INVALID_MEMBER.build(memberId));
    }
}
