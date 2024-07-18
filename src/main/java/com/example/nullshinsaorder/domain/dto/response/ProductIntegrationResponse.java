package com.example.nullshinsaorder.domain.dto.response;

import com.example.nullshinsaorder.domain.enumeration.CouponApplyPossible;

import java.util.List;

public record ProductIntegrationResponse(
        Long productId,
        String name,
        int price,
        String fabric,
        String manufacturingCountry,
        String washCaution,
        String manufacturingDate,
        String qualityGuarantee,
        CouponApplyPossible couponApplyPossible,
        List<ProductOptionResponse> productOptionResponseList) {
}
