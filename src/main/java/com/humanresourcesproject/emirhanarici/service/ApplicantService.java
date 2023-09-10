package com.humanresourcesproject.emirhanarici.service;

import com.humanresourcesproject.emirhanarici.dto.ApplicantDto;
import com.humanresourcesproject.emirhanarici.dto.ApplicationDto;
import com.humanresourcesproject.emirhanarici.entity.Applicant;
import com.humanresourcesproject.emirhanarici.repository.ApplicantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplicantService {

    private final ApplicantRepository applicantRepository;

    public List<ApplicantDto> getAllApplicant() {
        List<Applicant> applicants = applicantRepository.findAll();

        return applicants
                .stream()
                .map(ApplicantDto::convertToDto)
                .collect(Collectors.toList());
    }

    public ApplicantDto getOneApplicantByEmail(String email) {
        Applicant applicant = applicantRepository.findTopByEmail(email)
                .orElseThrow();

        return ApplicantDto.convertToDto(applicant);
    }
}
