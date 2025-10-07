package com.ecommerce.ecommerceapi_.repo.product;

import com.ecommerce.ecommerceapi_.Model.product.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryRepo extends JpaRepository<SubCategory, Long> {
}
