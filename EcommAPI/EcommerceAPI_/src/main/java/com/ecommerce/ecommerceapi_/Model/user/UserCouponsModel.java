package com.ecommerce.ecommerceapi_.Model.user;

import com.ecommerce.ecommerceapi_.Model.coupen.CoupenModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class UserCouponsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean completed;
    private boolean paid;
    @OneToMany
    private List<CoupenModel> coupnList;
}
