package com.example.nullshinsaorder.presentaion;

import com.example.nullshinsaorder.application.CouponCommandService;
import com.example.nullshinsaorder.domain.dto.request.CouponSaveRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CouponCommandController {
    private final CouponCommandService couponCommandService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/coupons")
    public void saveCoupon(@Valid @RequestBody CouponSaveRequest request) {
        couponCommandService.saveCoupon(request);
    }
}
