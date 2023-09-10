package com.humanresourcesproject.emirhanarici.service;

import com.humanresourcesproject.emirhanarici.dto.CreateJobRequest;
import com.humanresourcesproject.emirhanarici.dto.JobDto;
import com.humanresourcesproject.emirhanarici.dto.converter.JobConverter;
import com.humanresourcesproject.emirhanarici.entity.Job;
import com.humanresourcesproject.emirhanarici.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobService {

    private final JobRepository jobRepository;
    private final JobConverter jobConverter;

    public JobService(JobRepository jobRepository, JobConverter jobConverter) {
        this.jobRepository = jobRepository;
        this.jobConverter = jobConverter;
    }

    public JobDto createJob(CreateJobRequest request) {

        Job job = jobRepository.save(jobConverter.mapToEntity(request));

        return JobDto.convertToDto(job);
    }

    public List<JobDto> getAllJobs() {
        List<Job> job = jobRepository.findAll();

        return job
                .stream()
                .map(JobDto::convertToDto)
                .collect(Collectors.toList());
    }

    public JobDto getOneJobByPosition(String position) {

        Job job = jobRepository.findFirstByPosition(position);

        return JobDto.convertToDto(job);
    }



    public void deleteJob(String code) {
        jobRepository.deleteById(code);
    }
}
