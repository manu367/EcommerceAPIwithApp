package com.ecommerce.ecommerceapi_.repo.product;

import com.ecommerce.ecommerceapi_.Model.product.ProductDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailsRepo extends JpaRepository<ProductDetailsModel,Long> {
}
