package com.ecommerce.ecommerceapi_.Model.review;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ReviewMedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mediaTitle;
    private String url;
    private String mediaType;

    @ManyToOne
    @JoinColumn(name = "review_id")
    private ReviewModel review;
}
