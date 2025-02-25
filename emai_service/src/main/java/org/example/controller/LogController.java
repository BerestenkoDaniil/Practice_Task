package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.EmailLog;
import org.example.repository.LogRepository;
import org.example.service.LogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
@RequiredArgsConstructor

public class LogController {
    private final LogService logService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<EmailLog>> getUserLogs(@PathVariable Long userId) {
        return ResponseEntity.ok(logService.getUserLogs(userId));
    }
}
