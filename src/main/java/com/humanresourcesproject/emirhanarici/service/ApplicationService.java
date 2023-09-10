package com.humanresourcesproject.emirhanarici.service;

import com.humanresourcesproject.emirhanarici.dto.ApplicationDto;
import com.humanresourcesproject.emirhanarici.dto.CreateApplicationRequest;
import com.humanresourcesproject.emirhanarici.dto.JobDto;
import com.humanresourcesproject.emirhanarici.dto.converter.ApplicationConverter;
import com.humanresourcesproject.emirhanarici.entity.Application;
import com.humanresourcesproject.emirhanarici.entity.Job;
import com.humanresourcesproject.emirhanarici.repository.ApplicationRepository;
import com.humanresourcesproject.emirhanarici.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final ApplicationConverter applicationConverter;
    private final JobRepository jobRepository;

    public ApplicationDto create(CreateApplicationRequest request) {
        Application application = applicationRepository.save(applicationConverter.mapToEntity(request));

        return ApplicationDto.convertToDto(application);
    }

    public List<ApplicationDto> getAllApplication() {
        List<Application> applications = applicationRepository.findAll();

        return applications
                .stream()
                .map(ApplicationDto::convertToDto)
                .collect(Collectors.toList());
    }

    public List<JobDto> getAllApplicationsByUserId(String userId) {
        List<Application> applications = applicationRepository.findApplicationsByUserId(userId);

        List<Job> jobs = new ArrayList<>();

        for (int i = 0; i < applications.size(); i++) {
            jobs.add(jobRepository.findFirstByPosition(applications.stream().map(Application::getJobId).toList().get(i)));

            System.out.println(applications.stream().map(Application::getJobId).toList().get(i));

        }


        return jobs
                .stream()
                .map(JobDto::convertToDto)
                .collect(Collectors.toList());
    }
}
