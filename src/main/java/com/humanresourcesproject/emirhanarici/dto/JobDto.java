package com.humanresourcesproject.emirhanarici.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.humanresourcesproject.emirhanarici.entity.Job;

import java.time.LocalDate;
import java.util.List;

public record JobDto(
        String code,
        String position,
        String workType,
        String location,
        String jobDescription,
        List<String> todo,
        List<String> requirements,
        boolean isActive,
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate activationTime,
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate offTime


) {
    public static JobDto convertToDto(Job from) {
        return new JobDto(from.getCode(), from.getPosition(), from.getWorkType(), from.getLocation(), from.getJobDescription(), from.getTodo(), from.getRequirements(), from.isActive(), from.getActivationTime(), from.getOffTime());
    }
}
