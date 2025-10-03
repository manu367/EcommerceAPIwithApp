package com.ecommerce.ecommerceapi_.mapper.request;

import lombok.Data;

@Data
public class ProductRequest{
    private String name;
    private String description;
    private double price;
    private int stock;
}
