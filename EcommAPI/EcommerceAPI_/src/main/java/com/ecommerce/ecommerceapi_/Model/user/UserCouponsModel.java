package com.ecommerce.ecommerceapi_.Model.user;

import com.ecommerce.ecommerceapi_.Model.coupen.CoupenModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCouponsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean completed;
    private boolean paid;

    @OneToMany(cascade = CascadeType.ALL)// FK in coupenModel table
    private List<CoupenModel> couponList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserModel user;
}
