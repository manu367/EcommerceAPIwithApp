package com.ecommerce.ecommerceapi_.Model.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLoginHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String ipAddress;
    private String device;
    private String browser;
    private String location;
    private java.time.LocalDateTime loginTime;
    private java.time.LocalDateTime logoutTime;
    private Boolean successful;
    private String failureReason;
    private String sessionId;
    private Boolean twoFactorUsed;
    private String authMethod;
    private String userAgent;
    private String locationAccuracy;
}
