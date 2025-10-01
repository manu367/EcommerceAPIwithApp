package com.example.ecommerceapp.model;


public class Review {
    private String name;
    private float rating;
    private String comment;

    public Review(String name, float rating, String comment) {
        this.name = name;
        this.rating = rating;
        this.comment = comment;
    }

    public String getName() { return name; }
    public float getRating() { return rating; }
    public String getComment() { return comment; }
}

