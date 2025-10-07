package com.ecommerce.ecommerceapi_.Model.order;

import com.ecommerce.ecommerceapi_.Model.coupen.CoupenModel;
import com.ecommerce.ecommerceapi_.Model.product.ProductModelModel;
import com.ecommerce.ecommerceapi_.Model.user.UserModel;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double totalAmount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    // An order can have many products, and a product can belong to many orders
    @ManyToMany
    @JoinTable(
            name = "order_products",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id")
    )
    private List<ProductModelModel> products;

    // Optional coupon used in this order
    @ManyToOne
    @JoinColumn(name = "coupen_id")
    private CoupenModel coupen;
}
