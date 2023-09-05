package com.humanresourcesproject.emirhanarici.repository;

import com.humanresourcesproject.emirhanarici.entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {

    Optional<Applicant> findTopByEmail(String email);
}
