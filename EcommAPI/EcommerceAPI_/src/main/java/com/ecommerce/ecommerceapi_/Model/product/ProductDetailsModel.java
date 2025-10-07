package com.ecommerce.ecommerceapi_.Model.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class    ProductDetailsModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    String shortDescription;
    String description;
    double price;
    double discount;
    String webview;
    Long soldUser;
    double rating;
    String tagproduct;
    @ElementCollection
    private List<String> keyFeatures;
    // Images in description
    @ElementCollection
    private List<String> imageUrls;
//    / Video URLs (optional)
    @ElementCollection
    private List<String> videoUrls;

    @OneToOne
    @JoinColumn(name = "product_id")
    private ProductModelModel product;
}
