package com.ecommerce.ecommerceapi_.Model.notification;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class NotificationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
}
