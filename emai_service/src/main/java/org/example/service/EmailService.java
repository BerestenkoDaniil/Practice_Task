package org.example.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.example.model.EmailLog;
import org.example.model.EmailLogType;
import org.example.model.User;
import org.example.repository.LogRepository;
import org.example.repository.UserRepository;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;
    private final UserRepository userRepository;
    private final LogRepository logRepository;

    public void sendEmail(Long userId) throws MessagingException {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(user.getUsername());
        helper.setSubject("Вітання!");
        helper.setText("Ім'я користувача: " + user.getUsername() + "\nДата створення: " + user.getUsername());

        mailSender.send(message);

        // Логування
        logRepository.save(new EmailLog(null, user.getUsername(), EmailLogType.REST, LocalDateTime.now()));
    }
}
