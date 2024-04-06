package org.example.model.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * This helper class creates a ResponseEntity object for controller endpoints.
 */
public class ResponseHandler {

    public static <T> ResponseEntity<BaseResponse<T>> generateResponse(T data, String message, HttpStatus status) {
        return new ResponseEntity<>(new BaseResponse<>(data, message), status);
    }

    public static ResponseEntity<BaseResponse<String>> generateDefaultOkResponse() {
        return generateResponse(null, "OK", HttpStatus.OK);
    }

    public static <T> ResponseEntity<BaseResponse<T>> generateDefaultOkResponse(T data) {
        return generateResponse(data, "OK", HttpStatus.OK);
    }
}