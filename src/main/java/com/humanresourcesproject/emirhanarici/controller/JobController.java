package com.humanresourcesproject.emirhanarici.controller;


import com.humanresourcesproject.emirhanarici.dto.CreateJobRequest;
import com.humanresourcesproject.emirhanarici.dto.JobDto;
import com.humanresourcesproject.emirhanarici.service.JobService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/job")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping
    public ResponseEntity<JobDto> createJob(@RequestBody CreateJobRequest request) {
        return ResponseEntity.ok(jobService.createJob(request));
    }


    @GetMapping
    public ResponseEntity<List<JobDto>> getAllJobs() {
        return ResponseEntity.ok(jobService.getAllJobs());
    }

    @GetMapping("/{position}")
    public ResponseEntity<JobDto> getOneJobByPosition(@PathVariable String position) {
        return ResponseEntity.ok(jobService.getOneJobByPosition(position));
    }



    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteJob(@PathVariable String code) {
        jobService.deleteJob(code);
        return ResponseEntity.noContent().build();
    }


}
