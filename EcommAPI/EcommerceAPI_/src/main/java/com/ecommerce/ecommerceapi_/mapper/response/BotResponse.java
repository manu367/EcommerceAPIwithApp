package com.ecommerce.ecommerceapi_.mapper.response;

import lombok.Data;

@Data
public class BotResponse {
    private String reply;        // bot's message to user
    private String type;         // type of response: "ORDER_STATUS", "PAYMENT", "SUPPORT", etc.
}
