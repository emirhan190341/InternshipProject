package com.humanresourcesproject.emirhanarici.repository;

import com.humanresourcesproject.emirhanarici.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    List<Application> findApplicationsByUserId(String userId);

}
