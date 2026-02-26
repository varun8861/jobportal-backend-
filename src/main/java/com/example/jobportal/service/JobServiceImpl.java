package com.example.jobportal.service;

import com.example.jobportal.model.Job;
import com.example.jobportal.repo.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService{

    private final JobRepository jobRepository;

    @Autowired
    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long jobId) {
        return jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job Not Found"));
    }

    @Override
    public Job updateJob(Long jobId, Job updatedJob) {
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("User not found!"));

        if(updatedJob.getDescription()!=null) job.setDescription(updatedJob.getDescription());
        if(updatedJob.getTitle()!=null) job.setTitle(updatedJob.getTitle());
        if(updatedJob.getSalary()!=null) job.setSalary(updatedJob.getSalary());
        if(updatedJob.getEmployer()!=null) job.setEmployer(updatedJob.getEmployer());

        return jobRepository.save(job);

    }

    @Override
    public void deleteJob(Long jobId) {
        jobRepository.deleteById(jobId);

    }

    @Override
    public List<Job> getAllJobs(Long employerId) {
        return jobRepository.findByEmployerId(employerId);
    }
}
