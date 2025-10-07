package com.ecommerce.ecommerceapi_.Model.notification;

import com.ecommerce.ecommerceapi_.Model.user.UserModel;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class NotificationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String message;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;
}
