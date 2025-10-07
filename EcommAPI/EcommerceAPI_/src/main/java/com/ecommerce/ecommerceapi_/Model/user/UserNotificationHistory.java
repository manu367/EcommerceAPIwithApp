package com.ecommerce.ecommerceapi_.Model.user;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserNotificationHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String message;
    @Column(name = "is_read")
    private boolean isread;
    @Temporal(TemporalType.TIMESTAMP)
    private Date readDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date sendDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserModel user;
}
