package com.dhs.modeKasu.application.controller;



import com.dhs.modeKasu.application.dto.request.LoginRequest;
import com.dhs.modeKasu.application.dto.response.LoginResponse;
import com.dhs.modeKasu.application.facade.MemberFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auth")
public class AuthController {
    private final MemberFacade memberFacade;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Valid LoginRequest request) {
        return memberFacade.loginMember(request);
    }

}
