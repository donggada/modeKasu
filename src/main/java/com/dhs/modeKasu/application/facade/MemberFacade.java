package com.dhs.modeKasu.application.facade;


import com.dhs.modeKasu.application.dto.request.LoginRequest;
import com.dhs.modeKasu.application.dto.request.MemberSignupRequest;
import com.dhs.modeKasu.application.dto.response.LoginResponse;
import com.dhs.modeKasu.application.dto.response.MemberSignupResponse;
import com.dhs.modeKasu.domain.service.MemberService;
import com.dhs.modeKasu.infrastructure.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberFacade {
    private final MemberService memberService;
    private final JwtTokenProvider jwtTokenProvider;

    public MemberSignupResponse signupMember(MemberSignupRequest request) {
        memberService.validateNewMember(request);

        return MemberSignupResponse.of(
                memberService.saveMember(request)
        );
    }

    public LoginResponse loginMember(LoginRequest request) {
        String loginId = memberService.authenticateMember(request).getLoginId();
        return LoginResponse.of(loginId, jwtTokenProvider.generateToken(loginId));
    }
}
