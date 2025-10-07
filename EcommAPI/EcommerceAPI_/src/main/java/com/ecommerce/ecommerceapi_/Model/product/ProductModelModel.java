package com.ecommerce.ecommerceapi_.Model.product;

import com.ecommerce.ecommerceapi_.Model.review.ReviewModel;
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
public class ProductModelModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    private SubCategory subcategory;


    // add multiple image and video
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductMediaModel> productMediaModelList;


    //add product details
    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private ProductDetailsModel productDetailsModel;

    //add review on product
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ReviewModel> reviewModelList;
}
