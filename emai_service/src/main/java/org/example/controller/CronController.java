package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.CronJob;
import org.example.service.CronService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cron")
@RequiredArgsConstructor
public class CronController {
    private final CronService cronService;

    @PostMapping
    public ResponseEntity<CronJob> createCronJob(@RequestBody String expression, Pageable pageable) {
        return ResponseEntity.ok(cronService.createCronJob(expression));
    }
    @GetMapping
    public ResponseEntity<List<CronJob>> getCronJobs(@RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(cronService.getAllCronJobs(pageable));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCronJob(@PathVariable Long id) {
        cronService.deleteCronJob(id);
        return ResponseEntity.noContent().build();
    }
}
