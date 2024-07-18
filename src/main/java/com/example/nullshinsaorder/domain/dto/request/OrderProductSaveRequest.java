package com.example.nullshinsaorder.domain.dto.request;

import lombok.Getter;
import lombok.ToString;

public record OrderProductSaveRequest (
        long sellerId,
        long productId,
        long productOptionId,
        boolean isUseCoupon,
        long couponId,
        double originPrice,
        double discountPrice,
        double finalPrice,
        int amount
){
}
