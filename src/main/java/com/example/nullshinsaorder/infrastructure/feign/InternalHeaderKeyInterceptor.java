package com.example.nullshinsaorder.infrastructure.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class InternalHeaderKeyInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        String internalHeaderKey = "Internal-Header-Key";
        template.header("Internal-Header-Key", internalHeaderKey);
    }
}
