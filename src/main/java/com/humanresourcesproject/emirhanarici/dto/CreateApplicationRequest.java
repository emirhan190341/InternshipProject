package com.humanresourcesproject.emirhanarici.dto;

public record CreateApplicationRequest(
        String firstname,
        String email,
        String phone,
        String coverLetter,
        String userId,
        String jobId

) {
}
