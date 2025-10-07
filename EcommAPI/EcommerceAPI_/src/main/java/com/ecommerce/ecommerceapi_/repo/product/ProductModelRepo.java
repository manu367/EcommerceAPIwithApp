package com.ecommerce.ecommerceapi_.repo.product;

import com.ecommerce.ecommerceapi_.Model.product.ProductMediaModel;
import com.ecommerce.ecommerceapi_.Model.product.ProductModelModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductModelRepo extends JpaRepository<ProductModelModel,Long> {
}
