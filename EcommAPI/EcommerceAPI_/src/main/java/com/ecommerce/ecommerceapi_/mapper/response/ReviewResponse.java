package com.ecommerce.ecommerceapi_.mapper.response;

import lombok.Data;

@Data
public class ReviewResponse {
    private Long id;
    private Long productId;
    private Long userId;
    private String comment;
    private int rating;
    private String image;
}
