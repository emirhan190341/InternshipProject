package com.humanresourcesproject.emirhanarici.dto.converter;

import com.humanresourcesproject.emirhanarici.dto.CreateApplicationRequest;
import com.humanresourcesproject.emirhanarici.entity.Application;
import com.humanresourcesproject.emirhanarici.repository.ApplicationRepository;
import com.humanresourcesproject.emirhanarici.repository.JobRepository;
import org.springframework.stereotype.Component;

@Component
public class ApplicationConverter {

    private final ApplicationRepository applicationRepository;

    public ApplicationConverter(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public Application mapToEntity(CreateApplicationRequest request) {
        return new Application(request.firstname(), request.email(), request.phone(), request.coverLetter(),request.userId(),request.jobId());
    }
}
