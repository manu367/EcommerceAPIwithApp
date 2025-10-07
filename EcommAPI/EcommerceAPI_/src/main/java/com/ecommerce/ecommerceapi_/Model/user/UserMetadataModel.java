package com.ecommerce.ecommerceapi_.Model.user;

import jakarta.persistence.*;
import lombok.*;
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
    private Long id;

    private LocalDateTime loginTime;
    private LocalDateTime logoutTime;
    private String deviceType;
    private String deviceName;
    private String deviceOSVersion;
    private String browser;
    private String userAgent;
    private String ipAddress;
    private String location;
    private String sessionToken;


    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserModel user;
}
