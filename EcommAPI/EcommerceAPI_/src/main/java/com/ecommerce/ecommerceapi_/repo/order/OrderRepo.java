package com.ecommerce.ecommerceapi_.repo.order;

import com.ecommerce.ecommerceapi_.Model.order.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<OrderModel, Integer> {
}
