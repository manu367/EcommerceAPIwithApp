package com.ecommerce.ecommerceapi_.Model.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductModelModel{
    @Id
    Long id;
    String name;
    String description;

}
