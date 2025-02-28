package com.dhs.modeKasu.application.facade;


import com.dhs.modeKasu.application.dto.request.LoginRequest;
import com.dhs.modeKasu.application.dto.request.MemberSignupRequest;
import com.dhs.modeKasu.application.dto.response.LoginResponse;
import com.dhs.modeKasu.application.dto.response.MemberSignupResponse;
import com.dhs.modeKasu.domain.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberFacade {
    private final MemberService memberService;

    public MemberSignupResponse registerMember (MemberSignupRequest request) {
        return MemberSignupResponse.of(
                memberService.saveMember(request)
        );
    }

    public LoginResponse loginMember(LoginRequest request) {
        return LoginResponse.of(
                memberService.authenticateMember(request)
        );
    }
}
