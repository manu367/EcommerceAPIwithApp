package com.ecommerce.ecommerceapi_.mapper.request;

import lombok.Data;

@Data
public class EmailRequest {
    private String to;       // recipient
    private String subject;
    private String body;
}
