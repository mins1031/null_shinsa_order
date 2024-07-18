package com.example.nullshinsaorder.domain.exception;

import lombok.Getter;

@Getter
public class OrderException extends RuntimeException {
    private OrderExceptionCode orderExceptionCode;

    public OrderException(OrderExceptionCode orderExceptionCode) {
        this.orderExceptionCode = orderExceptionCode;
    }

    public OrderException(String errorMessage) {
        super(errorMessage);
    }
}
