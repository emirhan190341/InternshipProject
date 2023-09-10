package com.humanresourcesproject.emirhanarici.dto;

import com.humanresourcesproject.emirhanarici.entity.Application;

public record ApplicationDto(
        Long id,
        String firstname,
        String email,
        String phone,
        String coverLetter,
        String userId,
        String jobId
) {
    public static ApplicationDto convertToDto(Application from) {
        return new ApplicationDto(from.getId(), from.getFirstname(), from.getEmail(),from.getPhone(), from.getCoverLetter(),from.getUserId(),from.getJobId());
    }
}
