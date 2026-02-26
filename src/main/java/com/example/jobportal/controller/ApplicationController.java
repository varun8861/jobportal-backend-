package com.example.jobportal.controller;

import com.example.jobportal.model.Application;
import com.example.jobportal.model.ApplicationStatus;
import com.example.jobportal.service.ApplicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping("/apply")
    public Application apply(@RequestParam Long userId,
                             @RequestParam Long jobId) {
        return applicationService.applyToJob(userId, jobId);
    }

    @GetMapping("/job/{jobId}")
    public List<Application> getByJob(@PathVariable Long jobId) {
        return applicationService.getApplicationsByJob(jobId);
    }

    @GetMapping("/user/{userId}")
    public List<Application> getByUser(@PathVariable Long userId) {
        return applicationService.getApplicationsByUser(userId);
    }

    @PatchMapping("/{id}/status")
    public Application updateStatus(@PathVariable Long id,
                                    @RequestParam ApplicationStatus status) {
        return applicationService.updateApplicationStatus(id, status);
    }
}
