package com.example.nullshinsaorder.domain.dto.request;

import lombok.Getter;
import lombok.ToString;

public record OrderPurchaserInfoRequest(
        long purchaseId, 
        String purchaseName, 
        String purchaseEmail, 
        String purchasePublicPhone, 
        String purchaseCellPhone) {}
