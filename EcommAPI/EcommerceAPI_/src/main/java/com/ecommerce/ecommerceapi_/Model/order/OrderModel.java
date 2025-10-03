package com.ecommerce.ecommerceapi_.Model.order;

import com.ecommerce.ecommerceapi_.Model.user.UserModel;
import com.ecommerce.ecommerceapi_.Model.user.UserOrderHistoryModel;
import jakarta.persistence.*;

@Entity
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
