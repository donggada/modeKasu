package com.dhs.modeKasu.domain.service;


import com.dhs.modeKasu.application.dto.request.LoginRequest;
import com.dhs.modeKasu.application.dto.request.MemberSignupRequest;
import com.dhs.modeKasu.domain.model.member.Member;
import com.dhs.modeKasu.domain.model.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.dhs.modeKasu.infrastructure.exception.ErrorCode.*;


@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public Member saveMember(MemberSignupRequest request) {
        return memberRepository.save(Member.createMember(request, passwordEncoder.encode(request.password())));
    }

    public Member authenticateMember(LoginRequest request) {
        Member member = memberRepository.findByLoginId(request.login()).orElseThrow(() -> INVALID_LOGIN_ID.build(request.login()));

        if (!passwordEncoder.matches(request.password(), member.getPassword())) {
            throw INVALID_PASSWORD.build();
        }

        return member;
    }

    public void validateNewMember(MemberSignupRequest request) {
        if (memberRepository.existsByLoginId(request.loginId())) {
            throw DUPLICATE_LOGIN_ID.build(request.loginId());
        }
    }

}
