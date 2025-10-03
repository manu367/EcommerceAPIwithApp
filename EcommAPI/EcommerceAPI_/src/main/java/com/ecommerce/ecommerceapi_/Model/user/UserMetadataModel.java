package com.ecommerce.ecommerceapi_.Model.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserMetadataModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    // User reference (optional, if you have User entity)
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "login_time", nullable = false)
    private LocalDateTime loginTime;

    @Column(name = "logout_time")
    private LocalDateTime logoutTime;

    @Column(name = "device_type")
    private String deviceType; // e.g., Android, iOS, Web

    @Column(name = "device_name")
    private String deviceName; // e.g., Pixel 7, MacBook

    @Column(name = "device_os_version")
    private String deviceOSVersion;

    @Column(name = "browser")
    private String browser; // Chrome, Safari, Firefox

    @Column(name = "user_agent")
    private String userAgent;



    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "location")
    private String location; // Optional: city/country

    @Column(name = "session_token")
    private String sessionToken; // Optional: track sessions

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
