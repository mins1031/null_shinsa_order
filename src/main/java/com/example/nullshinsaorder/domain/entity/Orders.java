package com.example.nullshinsaorder.domain.entity;

import com.example.nullshinsaorder.domain.enumeration.OrderStatus;
import com.example.nullshinsaorder.domain.enumeration.OrderType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;
    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime updatedDate;
    @Column(nullable = false)
    private Long purchaserId;
    @Column(nullable = false)
    private OrderStatus orderStatus;
    @Column(nullable = false)
    private OrderType orderType;
    private int totalPrice;
    private int saveMileage;
    private int useMileage;
    private int payPrice;

    @Builder
    public Orders(Long purchaserId, OrderStatus orderStatus, OrderType orderType, int totalPrice, int saveMileage, int useMileage, int payPrice) {
        this.purchaserId = purchaserId;
        this.orderStatus = orderStatus;
        this.orderType = orderType;
        this.totalPrice = totalPrice;
        this.saveMileage = saveMileage;
        this.useMileage = useMileage;
        this.payPrice = payPrice;
    }

    //애내는 얘내 컬럼에 order_id가 있으면 됨 필수로 참조해야하는 곳에서만 참조하는게 관계가 깔끔함
    //    @Column(nullable = false)
//    private Long purchaserAddressId;
//    @Column(nullable = false)
//    private Long orderPaymentId;
}
