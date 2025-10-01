package com.example.ecommerceapp.model;

import java.util.List;

public class CategoryWIseProduct {
    private int id;
    private String CategoryTitle;
    private List<Product> productList;

    public CategoryWIseProduct(int id, String categoryTitle, List<Product> productList) {
        this.id = id;
        CategoryTitle = categoryTitle;
        this.productList = productList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryTitle() {
        return CategoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        CategoryTitle = categoryTitle;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
