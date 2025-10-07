package com.ecommerce.ecommerceapi_.Model.user;

import com.ecommerce.ecommerceapi_.Model.notification.NotificationModel;
import com.ecommerce.ecommerceapi_.Model.review.ReviewModel;
import com.ecommerce.ecommerceapi_.Model.coupen.CoupenModel;
import com.ecommerce.ecommerceapi_.Model.order.OrderModel;
import com.ecommerce.ecommerceapi_.Model.wishlist.WishListModel;
import com.ecommerce.ecommerceapi_.constants.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;

    @Enumerated(EnumType.STRING)
    private Status status = Status.INACTIVE;

    private Boolean deleted = false;

    // One user can have multiple coupons
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CoupenModel> coupenModels;

    // One user can have multiple orders
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderModel> orderModels;

    // One user can have multiple wishlist items
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WishListModel> wishListModels;

    // One user can have multiple reviews
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReviewModel> reviewModels;

    // One user can have multiple notifications
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NotificationModel> notificationModels;


    // Address
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserAddressModel> addresses;

    // Coupon history
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserCouponsModel> couponsHistory;

    // Email history
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserEmailHistory> emailHistories;

    // Login history
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserLoginHistory> loginHistories;

    // Notification history
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserNotificationHistory> notificationHistories;

    // Order history
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserOrderHistoryModel> orderHistories;

    // Metadata (latest device/session info)
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private UserMetadataModel metadata;

    //search history
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserSearchHistory> userSearchHistories;
}
