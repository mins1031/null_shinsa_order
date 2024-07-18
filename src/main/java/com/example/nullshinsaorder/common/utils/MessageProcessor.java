package com.example.nullshinsaorder.common.utils;

import org.springframework.http.ResponseEntity;

public class MessageProcessor {

    public static  <T> String convertErrorMessage(String mainMessage, ResponseEntity<T> response) {
        StringBuilder errorMessageBuilder = new StringBuilder(mainMessage);
        errorMessageBuilder.append("\n");
        errorMessageBuilder.append("status code = ");
        errorMessageBuilder.append(response.getStatusCode());

        return errorMessageBuilder.toString();
    }
}
