package com.ecommerce.ecommerceapi_.Model.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSearchHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String searchitem;

    @ManyToOne
    @JoinColumn(name = "user_id")
    UserModel user;
}
