package com.example.ecommerceapp.model;

public class Category {
    private String name;
    private String imageUrl; // URL from API/server

    public Category(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}

