package com.ecommerce.ecommerceapi_.repo.review;

import com.ecommerce.ecommerceapi_.Model.review.ReviewMedia;
import com.ecommerce.ecommerceapi_.Model.review.ReviewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewModelRepo extends JpaRepository<ReviewModel, Long> {
}
