package com.ecommerce.ecommerceapi_.Model.user;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLoginHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ipAddress;
    private String device;
    private String browser;
    private String location;
    private LocalDateTime loginTime;
    private LocalDateTime logoutTime;
    private Boolean successful;
    private String failureReason;
    private String sessionId;
    private Boolean twoFactorUsed;
    private String authMethod;
    private String userAgent;
    private String locationAccuracy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserModel user;
}
