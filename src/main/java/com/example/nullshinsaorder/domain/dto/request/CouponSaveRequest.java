package com.example.nullshinsaorder.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public class CouponSaveRequest {
    @NotBlank(message = "쿠폰이름은 필수 데이터 입니다.")
    private String name;
    @NotNull(message = "쿠폰 할인값은 필수 데이터 입니다.")
    private double discountPercent;
    @NotNull(message = "쿠폰 유효기간 시작날짜는 필수 데이터 입니다.")
    private LocalDateTime availableStartDate;
    @NotNull(message = "쿠폰 유효기간 마감날짜는 필수 데이터 입니다.")
    private LocalDateTime availableEndDate;

    //TODO 솔직히 코드상에서 오롯이 테스트 작성을 위한 생성자인데.. 테스트 코드를 위해서 생성자를 작성하는것이 필요할까요? 필요없다면 dto 생성은 어떻게해서 테스트를 해야할까요?
    public CouponSaveRequest(String name, double discountPercent, LocalDateTime availableStartDate, LocalDateTime availableEndDate) {
        this.name = name;
        this.discountPercent = discountPercent;
        this.availableStartDate = availableStartDate;
        this.availableEndDate = availableEndDate;
    }
}
