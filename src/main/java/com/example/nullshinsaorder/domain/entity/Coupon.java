package com.example.nullshinsaorder.domain.entity;

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
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;

    private String name;
    private double discountPercent;
    private LocalDateTime availableStartDate;
    private LocalDateTime availableEndDate;

    @Builder
    public Coupon(
            String name,
            double discountPercent,
            LocalDateTime availableStartDate,
            LocalDateTime availableEndDate) {
        this.name = name;
        this.discountPercent = discountPercent;
        this.availableStartDate = availableStartDate;
        this.availableEndDate = availableEndDate;
    }
}
