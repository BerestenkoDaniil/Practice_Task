package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "email_logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmailLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EmailLogType type;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdOn = LocalDateTime.now();

    public EmailLog(Long id, String name, EmailLogType emailLogType, LocalDateTime now) {
    }
}

