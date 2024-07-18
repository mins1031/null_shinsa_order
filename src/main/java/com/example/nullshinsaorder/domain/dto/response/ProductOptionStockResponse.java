package com.example.nullshinsaorder.domain.dto.response;

public record ProductOptionStockResponse(
        long productOptionId,
        int remainingStock,
        boolean isSoldOut
){
}
