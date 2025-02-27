package com.dhs.modeKasu.domain.factory.payment;

import com.dhs.modeKasu.domain.model.payment.Payment;
import org.springframework.stereotype.Service;

public interface PaymentService {
    Payment processPayment(Long orderId, int amount);
    void completePayment(String transactionId);
    void cancelPayment(String transactionId, String reason);
}
