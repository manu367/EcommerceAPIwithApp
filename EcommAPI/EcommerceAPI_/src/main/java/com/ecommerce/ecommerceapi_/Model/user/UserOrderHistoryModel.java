package com.ecommerce.ecommerceapi_.Model.user;

import com.ecommerce.ecommerceapi_.Model.order.OrderModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserOrderHistoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<OrderModel> orders;
    private boolean completed;
}
