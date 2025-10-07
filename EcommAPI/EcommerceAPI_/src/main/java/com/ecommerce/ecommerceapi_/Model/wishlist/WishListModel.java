package com.ecommerce.ecommerceapi_.Model.wishlist;

import com.ecommerce.ecommerceapi_.Model.product.ProductModelModel;
import com.ecommerce.ecommerceapi_.Model.user.UserModel;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class WishListModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductModelModel product;
}
