package com.example.jobportal.service;

import ch.qos.logback.classic.encoder.JsonEncoder;
import com.example.jobportal.model.User;
import com.example.jobportal.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(User user) {


        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User getUserDetails(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found!"));
    }

    @Override
    public User updateUserDetails(Long id, User updatedUser) {
        User user=userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found!"));
        if (updatedUser.getName() != null) {
            user.setName(updatedUser.getName());
        }
        if(updatedUser.getEmail()!=null){
            user.setEmail(updatedUser.getEmail());
        }
        if(updatedUser.getPassword()!=null){
            user.setPassword(updatedUser.getPassword());
        }

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);

    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
