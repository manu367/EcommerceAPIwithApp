package com.ecommerce.ecommerceapi_.Model.coupen;

import com.ecommerce.ecommerceapi_.Model.user.UserCouponsModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CoupenModel {
    @Id
    Long id;
    private String coupencode;
    private boolean active;

    @ManyToOne
    UserCouponsModel coupen;
}
