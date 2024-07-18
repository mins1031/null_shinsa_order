package com.example.nullshinsaorder.presentaion;

import com.example.nullshinsaorder.application.OrderCommandService;
import com.example.nullshinsaorder.domain.dto.request.TempOrderSaveRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class OrderCommandController {
    private final OrderCommandService orderCommandService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/orders/temp")
    public void saveTempOrder(@Valid @RequestBody TempOrderSaveRequest request) {
        orderCommandService.saveTempOrder(request);
    }
}
