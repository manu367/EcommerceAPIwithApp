package com.example.ecommerceapp.model;

public class Product {
    private int id;
    private String producttitle;
    private String imageURL;

    public Product(int id, String producttitle, String imageURL) {
        this.id = id;
        this.producttitle = producttitle;
        this.imageURL = imageURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProducttitle() {
        return producttitle;
    }

    public void setProducttitle(String producttitle) {
        this.producttitle = producttitle;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
