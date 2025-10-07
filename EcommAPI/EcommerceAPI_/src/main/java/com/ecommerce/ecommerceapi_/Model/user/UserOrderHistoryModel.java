package com.ecommerce.ecommerceapi_.Model.user;

import com.ecommerce.ecommerceapi_.Model.order.OrderModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserOrderHistoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean completed;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_order_history_id")
    private List<OrderModel> orders;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserModel user;
}
