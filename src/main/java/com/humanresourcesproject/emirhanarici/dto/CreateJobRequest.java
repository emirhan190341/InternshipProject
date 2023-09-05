package com.humanresourcesproject.emirhanarici.dto;

import java.time.LocalDate;
import java.util.List;

public record CreateJobRequest(
        String position,
        String workType,
        String location,
        String jobDescription,
        List<String> todo,
        List<String> requirements,
        boolean isActive,
        LocalDate activationTime,
        LocalDate offTime
) {
}
