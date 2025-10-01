package com.ecommerce.ecommerceapi_.Model.order;

import com.ecommerce.ecommerceapi_.Model.user.UserModel;
import jakarta.persistence.*;

@Entity
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



    @ManyToOne
    @JoinColumn(name = "user_model_id")
    private UserModel userModel;



}
