package com.dhs.modeKasu.application.controller;


import com.dhs.modeKasu.application.dto.request.MemberSignupRequest;
import com.dhs.modeKasu.application.dto.response.MemberSignupResponse;
import com.dhs.modeKasu.application.facade.MemberFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/member")
public class MemberController {
    private final MemberFacade memberFacade;

    @PostMapping("")
    public MemberSignupResponse signupMember (@RequestBody @Valid MemberSignupRequest request) {
        return memberFacade.signupMember(request);
    }


}
