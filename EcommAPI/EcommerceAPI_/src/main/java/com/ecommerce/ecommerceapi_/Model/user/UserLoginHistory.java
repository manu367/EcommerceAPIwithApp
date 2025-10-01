package com.ecommerce.ecommerceapi_.Model.user;

public class UserLoginHistory {
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
