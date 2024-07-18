package com.example.nullshinsaorder.infrastructure.repository;

import com.example.nullshinsaorder.domain.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {
}
