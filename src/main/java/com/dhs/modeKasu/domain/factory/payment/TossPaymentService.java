package com.dhs.modeKasu.domain.factory.payment;

import com.dhs.modeKasu.domain.model.payment.Payment;
import org.springframework.stereotype.Service;

@Service
public class TossPaymentService implements PaymentService {

    @Override
    public Payment processPayment(Long orderId, int amount) {
        return null;
    }

    @Override
    public void completePayment(String transactionId) {

    }

    @Override
    public void cancelPayment(String transactionId, String reason) {

    }
}
