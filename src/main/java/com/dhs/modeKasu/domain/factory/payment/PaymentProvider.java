package com.dhs.modeKasu.domain.factory.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentProvider {
    TOSS("토스"),
    KAKAO("카카오"),
    KCP("KCP");

    private final String providerName;
}
