package com.example.nullshinsaorder.domain.entity;

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
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;
    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime updatedDate;

    @Column(nullable = false)
    private Long productId;
    @Column(nullable = false)
    private Long productOptionId;

    private boolean isUseCoupon;
    private Long couponId;

    private boolean isCancel;
    private boolean isExchange;
    private boolean isPay;
    private boolean isDelivery;
    private Long possibleWithdraw;
    private Long possibleCancel;
    private Long possibleReturn;
    private Long possibleExchange;
    private Long possibleOrderModify;

    @Builder
    public OrderProduct(
            Long productId,
            Long productOptionId,
            boolean isUseCoupon,
            Long couponId,
            boolean isCancel,
            boolean isExchange,
            boolean isPay,
            boolean isDelivery,
            Long possibleWithdraw,
            Long possibleCancel,
            Long possibleReturn,
            Long possibleExchange,
            Long possibleOrderModify) {
        this.productId = productId;
        this.productOptionId = productOptionId;
        this.isUseCoupon = isUseCoupon;
        this.couponId = couponId;
        this.isCancel = isCancel;
        this.isExchange = isExchange;
        this.isPay = isPay;
        this.isDelivery = isDelivery;
        this.possibleWithdraw = possibleWithdraw;
        this.possibleCancel = possibleCancel;
        this.possibleReturn = possibleReturn;
        this.possibleExchange = possibleExchange;
        this.possibleOrderModify = possibleOrderModify;
    }
}
