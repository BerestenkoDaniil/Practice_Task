package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "cron_jobs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CronJob {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String expression;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdOn = LocalDateTime.now();
}
