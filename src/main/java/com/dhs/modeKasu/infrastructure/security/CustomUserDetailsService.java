package com.dhs.modeKasu.infrastructure.security;


import com.dhs.modeKasu.domain.model.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import static com.dhs.modeKasu.infrastructure.exception.ErrorCode.MEMBER_NOT_FOUND;


@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String loginId) {
        return new CustomUserDetails(
                memberRepository.findTokenCheckByLoginId(loginId)
                        .orElseThrow(() -> MEMBER_NOT_FOUND.build(loginId))
        ); // UserDetails 구현체 반환
    }
}

