package com.humanresourcesproject.emirhanarici.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String email;
    private String phone;
    private String coverLetter;
    private String userId;
    private String jobId;

    public Application(String firstname, String email, String phone, String coverLetter, String userId, String jobId) {
        this.firstname = firstname;
        this.email = email;
        this.phone = phone;
        this.coverLetter = coverLetter;
        this.userId = userId;
        this.jobId = jobId;
    }
}
