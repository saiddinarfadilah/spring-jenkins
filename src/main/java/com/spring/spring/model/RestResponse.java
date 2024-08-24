package com.spring.spring.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RestResponse {
    private String statusCode;
    private String statusMessage;
}
