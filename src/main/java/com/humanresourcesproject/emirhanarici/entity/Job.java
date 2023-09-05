package com.humanresourcesproject.emirhanarici.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "t_job")
@AllArgsConstructor
@NoArgsConstructor
public class Job {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String code;
    private String position;
    private String workType;
    private String location;
    @Column(length = 65555)
    private String jobDescription;
    @ElementCollection
    private List<String> todo;
    @ElementCollection
    private List<String> requirements;
    private boolean isActive;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate activationTime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate offTime;

    public Job(String position, String workType, String location, String jobDescription, List<String> todo, List<String> requirements, boolean isActive, LocalDate activationTime, LocalDate offTime) {
        this.position = position;
        this.workType = workType;
        this.location = location;
        this.jobDescription = jobDescription;
        this.todo = todo;
        this.requirements = requirements;
        this.isActive = isActive;
        this.activationTime = activationTime;
        this.offTime = offTime;
    }
}
