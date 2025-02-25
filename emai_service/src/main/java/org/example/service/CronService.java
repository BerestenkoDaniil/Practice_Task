package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.model.CronJob;
import org.example.repository.CronRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CronService {
    private final CronRepository cronRepository;

    public CronJob createCronJob(String expression) {
        CronJob cronJob = new CronJob();
        cronJob.setExpression(expression);
        return cronRepository.save(cronJob);
    }

    public List<CronJob> getAllCronJobs(Pageable pageable) {
        return cronRepository.findAll(pageable).getContent();
    }

    public void deleteCronJob(Long id) {
        cronRepository.deleteById(id);
    }
}
