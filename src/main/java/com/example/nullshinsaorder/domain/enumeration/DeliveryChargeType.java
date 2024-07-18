package com.example.nullshinsaorder.domain.enumeration;

import lombok.Getter;

@Getter
public enum DeliveryChargeType {
    FREE("무료", 0),
    MOUNTAIN_OR_ISLAND("산간, 섬지역", 3000),
    ;

    private final String desc;
    private final int deliveryCost;

    DeliveryChargeType(String desc, int deliveryCost) {
        this.desc = desc;
        this.deliveryCost = deliveryCost;
    }
}
