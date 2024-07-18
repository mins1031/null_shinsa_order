package com.example.nullshinsaorder.infrastructure.repository;

import com.example.nullshinsaorder.domain.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
