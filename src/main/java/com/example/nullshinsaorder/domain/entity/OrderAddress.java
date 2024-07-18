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
public class OrderAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;
    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime updatedDate;

    @Column(nullable = false)
    private Long orderId;
    private String departZipcode;
    private String departMainAddress;
    private String departDetailAddress;
    @Column(nullable = false)
    private String arrivalZipcode;
    @Column(nullable = false)
    private String arrivalMainAddress;
    @Column(nullable = false)
    private String arrivalDetailAddress;

    @Builder
    public OrderAddress(Long orderId, String departZipcode, String departMainAddress, String departDetailAddress, String arrivalZipcode, String arrivalMainAddress, String arrivalDetailAddress) {
        this.orderId = orderId;
        this.departZipcode = departZipcode;
        this.departMainAddress = departMainAddress;
        this.departDetailAddress = departDetailAddress;
        this.arrivalZipcode = arrivalZipcode;
        this.arrivalMainAddress = arrivalMainAddress;
        this.arrivalDetailAddress = arrivalDetailAddress;
    }
}
