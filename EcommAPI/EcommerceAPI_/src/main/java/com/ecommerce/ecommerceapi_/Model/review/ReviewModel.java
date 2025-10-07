package com.ecommerce.ecommerceapi_.Model.review;

import com.ecommerce.ecommerceapi_.Model.product.ProductModelModel;
import com.ecommerce.ecommerceapi_.Model.user.UserModel;
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
public class ReviewModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Double rating;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    private List<ReviewMedia> medias;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductModelModel product;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;
}
