package com.dhs.modeKasu.domain.model.member;


import com.dhs.modeKasu.application.dto.request.MemberSignupRequest;
import com.dhs.modeKasu.domain.model.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = false)
@ToString
public class Member extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String loginId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String phoneNumber;


    private Member(String loginId, String password, String username, String phoneNumber) {
        this.loginId = loginId;
        this.password = password;
        this.username = username;
        this.phoneNumber = phoneNumber;
    }

    public static Member createMember(MemberSignupRequest request, String encodePassword) {
        return new Member(request.loginId(), encodePassword, request.username(), request.phoneNumber());
    }

}
