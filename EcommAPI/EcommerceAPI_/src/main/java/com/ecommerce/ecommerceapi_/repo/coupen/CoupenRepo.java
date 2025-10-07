package com.ecommerce.ecommerceapi_.repo.coupen;

import com.ecommerce.ecommerceapi_.Model.coupen.CoupenModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoupenRepo  extends JpaRepository<CoupenModel,Long> {
}
