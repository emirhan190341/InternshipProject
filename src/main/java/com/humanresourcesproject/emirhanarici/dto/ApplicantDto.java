package com.humanresourcesproject.emirhanarici.dto;

import com.humanresourcesproject.emirhanarici.entity.Applicant;

public record ApplicantDto(
        Integer id,
        String firstname,
        String lastname,
        String email

) {
    public static ApplicantDto convertToDto(Applicant from) {
        return new ApplicantDto(from.getId(), from.getFirstname(), from.getLastname(), from.getEmail());
    }
}
