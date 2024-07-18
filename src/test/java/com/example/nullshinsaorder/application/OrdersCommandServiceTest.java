package com.example.nullshinsaorder.application;

import com.example.nullshinsaorder.domain.aggregation.ProductAggregation;
import com.example.nullshinsaorder.domain.dto.request.OrderProductSaveRequest;
import com.example.nullshinsaorder.domain.dto.request.OrderPurchaserInfoRequest;
import com.example.nullshinsaorder.domain.dto.request.ShippingAddressRequest;
import com.example.nullshinsaorder.domain.dto.request.TempOrderSaveRequest;
import com.example.nullshinsaorder.domain.dto.response.ProductOptionStockResponse;
import com.example.nullshinsaorder.domain.enumeration.DeliveryChargeType;
import com.example.nullshinsaorder.domain.enumeration.PaymentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrdersCommandServiceTest {
    @Mock
    private ProductAggregation productAggregation;

    @InjectMocks
    private OrderCommandService orderCommandService;

    @DisplayName("임시 주문 인입후 정상상태라면 결제서버 결제 api 호출")
    @Test
    void 임시주문_정상동작() {
        //given
        OrderProductSaveRequest orderProductSaveRequest1 = new OrderProductSaveRequest(
                1L, 1L, 2L, true, 1L, 40000, 4000, 36000, 1
        );
        OrderProductSaveRequest orderProductSaveRequest2 = new OrderProductSaveRequest(
                1L, 2L, 3L, true, 2L, 50000, 10000, 40000, 2
        );
        List<OrderProductSaveRequest> orderProductSaveRequestList = List.of(orderProductSaveRequest1, orderProductSaveRequest2);

        OrderPurchaserInfoRequest orderPurchaserInfoRequest = new OrderPurchaserInfoRequest(
                1L, "정민영", "tt@email.com", "", "010-7777-7777"
        );
        ShippingAddressRequest shippingAddressRequest = new ShippingAddressRequest(
                "기본 배송지", "정민영", "", "010-7777-7777",
                "12736", "경기도 광주시 초월읍", "120층", "부재시 현관앞"
        );

        TempOrderSaveRequest tempOrderSaveRequest = new TempOrderSaveRequest(
                orderProductSaveRequestList,
                orderPurchaserInfoRequest,
                shippingAddressRequest,
                true,
                2000,
                1800,
                DeliveryChargeType.FREE,
                PaymentType.CARD_PAYMENT,
                90000,
                14000,
                76000
        );

        Map<Long, ProductOptionStockResponse> productOptionStockResponseList = Map.of(
                orderProductSaveRequest1.productOptionId(), new ProductOptionStockResponse(orderProductSaveRequest1.productOptionId(), 5, false),
                orderProductSaveRequest2.productOptionId(), new ProductOptionStockResponse(orderProductSaveRequest2.productOptionId(), 9, false)
        );

        //when
        when(productAggregation.findProductOptionStock(any())).thenReturn(productOptionStockResponseList);
        when(productAggregation.processPayment(tempOrderSaveRequest)).thenReturn(true);

        orderCommandService.saveTempOrder(tempOrderSaveRequest);

        //then
        verify(productAggregation, atLeastOnce()).findProductOptionStock(any());
        verify(productAggregation, atLeastOnce()).processPayment(tempOrderSaveRequest);
    }

}