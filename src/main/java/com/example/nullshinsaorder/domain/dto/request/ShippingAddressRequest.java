package com.example.nullshinsaorder.domain.dto.request;

public record ShippingAddressRequest(
        String shippingAddressName,
        String receiverName,
        String receiverTel,
        String receiverPhoneNum,
        String zipcode,
        String mainShippingAddress,
        String subShippingAddress,
        String detailMessage
) {
}
