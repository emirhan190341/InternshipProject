package com.humanresourcesproject.emirhanarici.controller;

import com.humanresourcesproject.emirhanarici.dto.ApplicantDto;
import com.humanresourcesproject.emirhanarici.dto.ApplicationDto;
import com.humanresourcesproject.emirhanarici.service.ApplicantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api/applicant")
@RequiredArgsConstructor
public class ApplicantController {

    private final ApplicantService applicantService;

    @GetMapping
    public ResponseEntity<List<ApplicantDto>> getAllApplicant() {
        return ResponseEntity.ok(applicantService.getAllApplicant());
    }

    @GetMapping("/{email}")
    public ResponseEntity<ApplicantDto> getOneApplicantByEmail(@PathVariable String email) {
        return ResponseEntity.ok(applicantService.getOneApplicantByEmail(email));

    }


}
