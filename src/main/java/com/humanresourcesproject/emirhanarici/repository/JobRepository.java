package com.humanresourcesproject.emirhanarici.repository;

import com.humanresourcesproject.emirhanarici.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, String> {

    Job findFirstByPosition(String positionName);
}
