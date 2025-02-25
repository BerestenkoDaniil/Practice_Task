package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.model.EmailLog;
import org.example.repository.LogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LogService {
    private final LogRepository logRepository;

    public List<EmailLog> getUserLogs(Long userId){
        return logRepository.findByUserId(userId);
    }
}
