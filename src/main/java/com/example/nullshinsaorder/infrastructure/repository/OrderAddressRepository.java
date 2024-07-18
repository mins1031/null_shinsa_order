package com.example.nullshinsaorder.infrastructure.repository;

import com.example.nullshinsaorder.domain.entity.OrderAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderAddressRepository extends JpaRepository<OrderAddress, Long> {
}
