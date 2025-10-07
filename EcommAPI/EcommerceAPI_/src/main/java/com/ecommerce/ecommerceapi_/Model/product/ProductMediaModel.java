package com.ecommerce.ecommerceapi_.Model.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductMediaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titleofImage;
    private String url;

    @ManyToOne
    @JoinColumn(name = "product_id")
    ProductModelModel product;

}
