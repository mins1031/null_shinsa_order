package com.example.nullshinsaorder.infrastructure.feign;

import com.example.nullshinsaorder.domain.dto.request.TempOrderSaveRequest;
import com.example.nullshinsaorder.domain.dto.response.ProductIntegrationResponse;
import com.example.nullshinsaorder.infrastructure.feign.InternalHeaderKeyInterceptor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PaymentClient", url = "http://localhost:8082", configuration = InternalHeaderKeyInterceptor.class)
public interface PaymentClient {
    @PostMapping("/payment")
    ResponseEntity<Boolean> processPayment(@RequestBody TempOrderSaveRequest request);

}
