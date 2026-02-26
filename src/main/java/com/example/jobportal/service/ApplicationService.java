package com.example.jobportal.service;

import com.example.jobportal.model.Application;
import com.example.jobportal.model.ApplicationStatus;
import com.example.jobportal.model.Job;
import com.example.jobportal.model.User;

import java.util.List;

public interface ApplicationService {
//    User can apply to job
//
//    Employer can view applicants for a job
//
//    User can see jobs they applied to

    Application applyToJob(Long userId, Long jobId);
    List<Application> getApplicationsByJob(Long jobId);
    List<Application>  getApplicationsByUser(Long userId);
    Application updateApplicationStatus(Long applicationId, ApplicationStatus status);


}
