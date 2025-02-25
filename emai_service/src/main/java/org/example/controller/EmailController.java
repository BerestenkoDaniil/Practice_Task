package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.service.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class EmailController {
    private final EmailService emailService;

    @PostMapping("/send/{userId}")
    public ResponseEntity<String> sendEmail(@PathVariable Long userId) {
        try {
            emailService.sendEmail(userId);
            return ResponseEntity.ok("Лист успішно відправлено");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Помилка відправки листа");
        }
    }
}
