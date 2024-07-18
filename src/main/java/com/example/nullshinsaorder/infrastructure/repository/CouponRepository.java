package com.example.nullshinsaorder.infrastructure.repository;

import com.example.nullshinsaorder.domain.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

}
