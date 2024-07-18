package com.example.nullshinsaorder.domain.aggregation;

import com.example.nullshinsaorder.common.utils.MessageProcessor;
import com.example.nullshinsaorder.domain.dto.request.TempOrderSaveRequest;
import com.example.nullshinsaorder.domain.exception.OrderException;
import com.example.nullshinsaorder.infrastructure.feign.PaymentClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentAggregation {
    private final PaymentClient paymentClient;

    public boolean processPayment(TempOrderSaveRequest request) {
        ResponseEntity<Boolean> response = paymentClient.processPayment(request);
        if (response.getStatusCode().is4xxClientError()) {
            log.error("결제처리 api 호출이 400번대 에러로 실패 했습니다. request = {}, response = {}", request, response);
            throw new OrderException(MessageProcessor.convertErrorMessage("재고 조회 api 호출이 400번대 에러로 실패", response));
        }

        if (response.getStatusCode().is5xxServerError()) {
            log.error("결제처리 api 호출이 500번대 에러로 실패 했습니다. request = {}, response = {}", request, response);
            throw new OrderException(MessageProcessor.convertErrorMessage("재고 조회 api 호출이 500번대 에러로 실패", response));
        }

        if (Objects.isNull(response.getBody())) {
            log.error("결제처리회 api 호출 응답 데이터가 없음. request = {}, response = {}", request, response);
            throw new OrderException(MessageProcessor.convertErrorMessage("재고 조회 api 호출 응답 데이터가 없음", response));
        }

        return response.getBody();
    }
}
