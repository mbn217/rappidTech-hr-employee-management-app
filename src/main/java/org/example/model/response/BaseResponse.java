package org.example.model.response;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

/**
 * This class is the generic base response class for controller endpoints.
 * These fields are included in all controller responses.
 *
 * @param <T> data model held in this response
 */
@Getter
@Setter
public class BaseResponse<T> {

    private ZonedDateTime timestamp;
    private String message;
    private T data;

    public BaseResponse() {
        timestamp = ZonedDateTime.now();
    }

    public BaseResponse(T data) {
        this();
        this.data = data;
    }

    public BaseResponse(T data, String message) {
        this(data);
        this.message = message;
    }

    public BaseResponse(Exception e) {
        this();
        this.message = e.getMessage();
    }
}