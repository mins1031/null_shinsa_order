package com.example.nullshinsaorder.domain.enumeration;

import lombok.Getter;

@Getter
public enum PaymentType {
    CARD_PAYMENT("신용/체크카드"),
    HYUNDAI_PIN_PAY("현대카드 X PIN PAY"),
    TOSS_PAY("토스 페이"),
    NAVER_PAY("네이버 페이"),
    KAKAO_PAY("카카오 페이"),
    SAMSUNG_PAY("삼성 페이"),
    PAYCO("페이코"),
    SSG_PAY("SSG 페이"),
    DEPOSIT_WITHOUT_BANKBOOK("무통장 입금"),

    ;

    private String payTypeName;

    PaymentType(String payTypeName) {
        this.payTypeName = payTypeName;
    }
}
