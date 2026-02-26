package com.example.jobportal.repo;

import com.example.jobportal.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ApplicationRepository extends JpaRepository<Application, Long> {


    boolean existsByUserIdAndJobId(Long userId, Long jobId);

    List<Application> findByJobId(Long jobId);

    List<Application> findByUserId(Long userId);
}
