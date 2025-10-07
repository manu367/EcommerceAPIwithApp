package com.ecommerce.ecommerceapi_.repo.notification;

import com.ecommerce.ecommerceapi_.Model.notification.NotificationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepo extends JpaRepository<NotificationModel, Long> {
}
