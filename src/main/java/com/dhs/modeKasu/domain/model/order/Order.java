package com.dhs.modeKasu.domain.model.order;

import com.dhs.modeKasu.domain.model.BaseTimeEntity;
import com.dhs.modeKasu.domain.model.member.Member;
import com.dhs.modeKasu.domain.model.payment.Payment;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "orders")
public class Order extends BaseTimeEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Payment> payments = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.PENDING;

    private int totalAmount;

    public Order(Member member, int totalAmount) {
        this.member = member;
        this.totalAmount = totalAmount;
    }

    public void completeOrder() {
        this.status = OrderStatus.COMPLETED;
    }

    public void cancelOrder() {
        this.status = OrderStatus.CANCELED;
    }
}
