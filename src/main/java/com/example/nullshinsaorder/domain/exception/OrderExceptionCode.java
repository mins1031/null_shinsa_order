package com.example.nullshinsaorder.domain.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum OrderExceptionCode {
    SOLD_OUT_ORDER_PRODUCT_STOCK(HttpStatus.BAD_REQUEST, 1001, "주문한 상품의 재고가 부족합니다."),
    ;

    private final HttpStatus httpStatus;
    private final int errorCode;
    private final String errorMessage;

    OrderExceptionCode(HttpStatus httpStatus, int errorCode, String errorMessage) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
