package com.example.nullshinsaorder.domain.aggregation;

import com.example.nullshinsaorder.common.utils.MessageProcessor;
import com.example.nullshinsaorder.domain.dto.request.TempOrderSaveRequest;
import com.example.nullshinsaorder.domain.dto.response.ProductOptionStockResponse;
import com.example.nullshinsaorder.domain.exception.OrderException;
import com.example.nullshinsaorder.domain.exception.OrderExceptionCode;
import com.example.nullshinsaorder.infrastructure.feign.PaymentClient;
import com.example.nullshinsaorder.infrastructure.feign.ProductClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductAggregation {
    private final ProductClient productClient;

    public Map<Long, ProductOptionStockResponse> findProductOptionStock(List<Long> productOptionIdList) {
        ResponseEntity<List<ProductOptionStockResponse>> response = productClient.findProductOptionStock(productOptionIdList);
        if (!response.getStatusCode().is2xxSuccessful()) {
            log.error("재고 조회 api 호출이 실패 했습니다. request = {}, response = {}", productOptionIdList, response);
            throw new OrderException(MessageProcessor.convertErrorMessage("재고 조회 api 호출 실패", response));
        }

        return Objects.requireNonNull(response.getBody()).stream().collect(Collectors.toMap(ProductOptionStockResponse::productOptionId, Function.identity()));
    }
}
