package com.example.jobportal.service;

import com.example.jobportal.model.Application;
import com.example.jobportal.model.ApplicationStatus;
import com.example.jobportal.model.Job;
import com.example.jobportal.model.User;
import com.example.jobportal.repo.ApplicationRepository;
import com.example.jobportal.repo.JobRepository;
import com.example.jobportal.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final UserRepository userRepository;
    private final JobRepository jobRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository,
                                  UserRepository userRepository,
                                  JobRepository jobRepository) {
        this.applicationRepository = applicationRepository;
        this.userRepository = userRepository;
        this.jobRepository = jobRepository;
    }

    @Override
    public Application applyToJob(Long userId, Long jobId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        // Prevent duplicate applications
        boolean alreadyApplied =
                applicationRepository.existsByUserIdAndJobId(userId, jobId);

        if (alreadyApplied) {
            throw new RuntimeException("User already applied to this job");
        }

        Application application = new Application();
        application.setUser(user);
        application.setJob(job);
        application.setApplicationStatus(ApplicationStatus.PENDING);

        return applicationRepository.save(application);
    }

    // ✅ Employer views all applications for a job
    @Override
    public List<Application> getApplicationsByJob(Long jobId) {

        jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        return applicationRepository.findByJobId(jobId);
    }

    // ✅ User views all applications they submitted
    @Override
    public List<Application> getApplicationsByUser(Long userId) {

        userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return applicationRepository.findByUserId(userId);
    }

    // ✅ Employer updates application status
    @Override
    public Application updateApplicationStatus(Long applicationId,
                                               ApplicationStatus status) {

        Application application = applicationRepository.findById(applicationId)
                .orElseThrow(() -> new RuntimeException("Application not found"));

        application.setApplicationStatus(status);

        return applicationRepository.save(application);
    }
}