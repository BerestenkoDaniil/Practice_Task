package org.example.repository;

import org.example.model.CronJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CronRepository extends JpaRepository<CronJob, Long> {
}
