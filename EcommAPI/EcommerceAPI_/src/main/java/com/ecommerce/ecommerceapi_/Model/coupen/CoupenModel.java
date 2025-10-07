package com.ecommerce.ecommerceapi_.Model.coupen;

import com.ecommerce.ecommerceapi_.Model.user.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CoupenModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String coupencode;
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;
}
