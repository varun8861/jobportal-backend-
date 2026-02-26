package com.example.jobportal.service;

import com.example.jobportal.model.Job;

import java.util.List;

public interface JobService {
//    Employer can:
//
//    Create job
//
//    Update job
//
//    Delete job
//
//    Anyone can:
//
//    View all jobs
//
//    View job by id

    Job createJob(Job job);
    Job getJobById(Long jobId);
    Job updateJob(Long jobId, Job updatedJob);
    void deleteJob(Long jobId);
    List<Job> getAllJobs(Long employerId);





}
