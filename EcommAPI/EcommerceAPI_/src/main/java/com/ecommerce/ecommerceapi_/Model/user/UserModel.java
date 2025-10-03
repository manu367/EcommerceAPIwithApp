package com.ecommerce.ecommerceapi_.Model.user;

import com.ecommerce.ecommerceapi_.constants.UserStatus;
import jakarta.persistence.*;

@Entity
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private UserStatus status = UserStatus.ACTIVE;
    // Soft delete flag
    @Column(name = "deleted", nullable = false)
    private Boolean deleted = false;
}
