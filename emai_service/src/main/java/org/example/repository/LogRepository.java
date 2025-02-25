package org.example.repository;

import lombok.extern.java.Log;
import org.example.model.EmailLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository

public interface LogRepository extends JpaRepository<EmailLog, Long> {
    List<EmailLog> findByUserId(Long userId);
}
