package com.example.nullshinsaorder.domain.dto.request;

import com.example.nullshinsaorder.domain.enumeration.DeliveryChargeType;
import com.example.nullshinsaorder.domain.enumeration.PaymentType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record TempOrderSaveRequest(
        @Size(min = 1, max = 10) @NotNull(message = "주문상품 정보는 필수값 입니다.") List<OrderProductSaveRequest> orderProductSaveRequests,
        @NotNull(message = "주문쟈 정보는 필수값 입니다.") OrderPurchaserInfoRequest orderPurchaserInfoRequest,
        @NotNull(message = "배송지 정보는 필수값 입니다.") ShippingAddressRequest shippingAddressRequest,
        boolean isUseMileage,
        int useMileage,
        int saveMileage,
        @NotNull(message = "배송비 정보는 필수값 입니다.") DeliveryChargeType deliveryChargeType,
        @NotNull(message = "결제정보는 필수값 입니다.") PaymentType paymentType,
        int originPrice,
        int discountPrice,
        int finalPrice
        //TODO 이러한 금액 정보에도 valid 이 필요할까요..?
){
}
