package com.ecommerce.ecommerceapi_.mapper.request;

import lombok.Data;

@Data
public class ReviewRequest {
    private Long productId;
    private Long userId;
    private String comment;
    private int rating;
}
