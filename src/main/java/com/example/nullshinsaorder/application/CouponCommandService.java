package com.example.nullshinsaorder.application;

import com.example.nullshinsaorder.domain.dto.request.CouponSaveRequest;
import com.example.nullshinsaorder.domain.entity.Coupon;
import com.example.nullshinsaorder.infrastructure.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CouponCommandService {
    private final CouponRepository couponRepository;

    @Transactional
    public void saveCoupon(CouponSaveRequest request) {
        //추후 member-coupon id를 order_product내로 변경하고 coupon은 독립적으로 존재하게 구성해야할듯
        Coupon coupon = Coupon.builder()
                .name(request.getName())
                .discountPercent(request.getDiscountPercent())
                .availableStartDate(request.getAvailableStartDate())
                .availableEndDate(request.getAvailableEndDate())
                .build();

        couponRepository.save(coupon);
    }
}
