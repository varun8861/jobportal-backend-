package com.example.jobportal.service;

import com.example.jobportal.model.User;

import java.util.List;

public interface UserService {

    User registerUser (User user);
    User getUserDetails(Long id);
    User updateUserDetails(Long id, User updatedUser);
    void deleteUser(Long id);
    List<User> getAllUsers();   // maybe admin only

}
