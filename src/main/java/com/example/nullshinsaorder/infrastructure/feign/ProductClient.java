package com.example.nullshinsaorder.infrastructure.feign;

import com.example.nullshinsaorder.domain.dto.response.ProductIntegrationResponse;
import com.example.nullshinsaorder.domain.dto.response.ProductOptionStockResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ProductClient", url = "http://localhost:8081", configuration = InternalHeaderKeyInterceptor.class)
public interface ProductClient {

    @GetMapping("/products/integration/{id}")
    ResponseEntity<ProductIntegrationResponse> findIntegrationProduct(@PathVariable(name = "id") Long userId);

    @GetMapping("/products/stock")
    ResponseEntity<List<ProductOptionStockResponse>> findProductOptionStock(List<Long> productOptionIdList);
}
