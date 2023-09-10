package com.humanresourcesproject.emirhanarici.repository;

import com.humanresourcesproject.emirhanarici.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, String> {

    Job findFirstByPosition(String positionName);

    List<Job> findAllByPosition(String jobId);
}
