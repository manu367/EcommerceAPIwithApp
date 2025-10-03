package com.ecommerce.ecommerceapi_.mapper.request;

import lombok.Data;

@Data
public class BotRequest {
    private Long userId;      // user sending the message
    private String message;   // user query
    private Long orderId;     // optional, if query is order-related
}
