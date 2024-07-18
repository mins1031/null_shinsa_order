package com.example.nullshinsaorder.application;

import com.example.nullshinsaorder.domain.aggregation.PaymentAggregation;
import com.example.nullshinsaorder.domain.aggregation.ProductAggregation;
import com.example.nullshinsaorder.domain.dto.request.OrderProductSaveRequest;
import com.example.nullshinsaorder.domain.dto.request.TempOrderSaveRequest;
import com.example.nullshinsaorder.domain.dto.response.ProductOptionStockResponse;
import com.example.nullshinsaorder.domain.exception.OrderException;
import com.example.nullshinsaorder.domain.exception.OrderExceptionCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderCommandService {
    private final ProductAggregation productAggregation;
    private final PaymentAggregation paymentAggregation;

    /**
     * 1. 요청 데이터 valid
     * 2. 상품조회
     *     1. 상품별 재고 validation
     *     2. 이미 재고가 없다면 뒤에 굳이 쓸데없이 결제-insert-통신비용 등등 들일 필요가 없다고 생각.
     * 3. 문제 없다면 임시주문데이터 결제 서버로 전송 (주문로그를 위해서 이때 주문번호를 생성하나..? -> 그런데 굳이..? 결제실패하면 데이터만 아까운데? -> 결제 실패하면 로그를 쌓나?)
     */
    @Transactional
    public void saveTempOrder(final TempOrderSaveRequest request) {
        final List<Long> productOptionIdList = request.orderProductSaveRequests().stream()
                .map(OrderProductSaveRequest::productOptionId)
                .collect(Collectors.toList());
        final Map<Long, ProductOptionStockResponse> productOptionStockResponses = productAggregation.findProductOptionStock(productOptionIdList);

        checkSoldOut(request, productOptionStockResponses);

        //TODO 카프카 도입 예정
        paymentAggregation.processPayment(request);
    }

    private void checkSoldOut(TempOrderSaveRequest request, Map<Long, ProductOptionStockResponse> productOptionStockResponses) {
        request.orderProductSaveRequests().forEach(
                orderProductSaveRequest -> {
                    ProductOptionStockResponse productStockResponse = productOptionStockResponses.get(orderProductSaveRequest.productOptionId());
                    int orderProductRequestAmount = orderProductSaveRequest.amount();
                    int presentRemainingStock = productStockResponse.remainingStock();

                    if (productStockResponse.isSoldOut()) {
                        throw new OrderException(OrderExceptionCode.SOLD_OUT_ORDER_PRODUCT_STOCK);
                    }

                    if (orderProductRequestAmount > presentRemainingStock) {
                        throw new OrderException(OrderExceptionCode.SOLD_OUT_ORDER_PRODUCT_STOCK);
                    }
                }
        );
    }
}
