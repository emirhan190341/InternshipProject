package com.humanresourcesproject.emirhanarici.controller;

import com.humanresourcesproject.emirhanarici.dto.ApplicationDto;
import com.humanresourcesproject.emirhanarici.dto.CreateApplicationRequest;
import com.humanresourcesproject.emirhanarici.dto.JobDto;
import com.humanresourcesproject.emirhanarici.entity.Applicant;
import com.humanresourcesproject.emirhanarici.entity.Application;
import com.humanresourcesproject.emirhanarici.repository.JobRepository;
import com.humanresourcesproject.emirhanarici.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/application")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    @PostMapping
    public ResponseEntity<ApplicationDto> createApplication(@RequestBody CreateApplicationRequest request) {
        return ResponseEntity.ok(applicationService.create(request));

    }

    @GetMapping
    public ResponseEntity<List<ApplicationDto>> getAllApplications() {
        return ResponseEntity.ok(applicationService.getAllApplication());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<JobDto>> getAllApplicationsByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(applicationService.getAllApplicationsByUserId(userId));
    }

}
