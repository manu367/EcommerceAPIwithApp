package com.ecommerce.ecommerceapi_.constants;

public interface ApiEndpoints {
    String API_BASE = "/api/v1";
    String PRODUCTS = API_BASE + "/products";
    String USERS = API_BASE + "/users";
    String ORDERS = API_BASE + "/orders";
    String REVIEWS = PRODUCTS + "/reviews";
    String EMAIL= API_BASE + "/email";
    String BOT = API_BASE + "/bot";
}
