package com.dhs.modeKasu.domain.model.payment;

import com.dhs.modeKasu.domain.model.BaseTimeEntity;
import com.dhs.modeKasu.domain.model.order.Order;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Payment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Enumerated(EnumType.STRING)
    private PaymentMethod method;

    private int amount;

    private String transactionId; // PG사에서 발급한 거래 ID

    @Enumerated(EnumType.STRING)
    private PaymentStatus status = PaymentStatus.PENDING;

    public Payment(Order order, PaymentMethod method, int amount, String transactionId) {
        this.order = order;
        this.method = method;
        this.amount = amount;
        this.transactionId = transactionId;
    }

    public void completePayment() {
        this.status = PaymentStatus.SUCCESS;
        this.order.completeOrder();
    }

    public void failPayment() {
        this.status = PaymentStatus.FAILED;
    }

    public void cancelPayment() {
        this.status = PaymentStatus.CANCELED;
        this.order.cancelOrder();
    }
}
