package com.example.nullshinsaorder.domain.dto.response;

public record ProductOptionResponse(
        long productOptionId,
        String color,
        String size,
        String length,
        String shoulder,
        String chest,
        String sleeve,
        String waist,
        String crotch,
        String hip,
        String thigh,
        String hem,
        int stock
) {
}
