package com.dhs.modeKasu.domain.factory.payment;

import lombok.RequiredArgsConstructor;
import org.springframework.aop.support.AopUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.dhs.modeKasu.infrastructure.exception.ErrorCode.INVALID_PAYMENT_SERVICE;

@Component
public class PaymentFactory {

    private final Map<Class, PaymentService> paymentServiceMap;

    public PaymentFactory(List<PaymentService> paymentServiceList) {
        this.paymentServiceMap = paymentServiceList.stream().collect(
                Collectors.toMap(
                        AopUtils::getTargetClass,
                        service -> service
                )
        );
    }

    public PaymentService getService(PaymentProvider type) {
        if (type.equals(PaymentProvider.TOSS)) {
            return paymentServiceMap.get(TossPaymentService.class);
        }

        throw INVALID_PAYMENT_SERVICE.build(type);
    }
}
