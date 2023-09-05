package com.humanresourcesproject.emirhanarici.dto.converter;

import com.humanresourcesproject.emirhanarici.dto.CreateJobRequest;
import com.humanresourcesproject.emirhanarici.entity.Job;
import com.humanresourcesproject.emirhanarici.repository.JobRepository;
import org.springframework.stereotype.Component;

@Component
public class JobConverter {

    private final JobRepository jobRepository;

    public JobConverter(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public Job mapToEntity(CreateJobRequest request) {
        return new Job(request.position(),request.workType(),request.location(),request.jobDescription(),request.todo(),request.requirements(),request.isActive(),request.activationTime(),request.offTime());
    }

}
