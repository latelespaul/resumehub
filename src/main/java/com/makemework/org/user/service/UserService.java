package com.makemework.org.user.service;

import org.springframework.stereotype.Service;
import com.makemework.org.user.model.User;
import com.makemework.org.user.repository.UserRepository;

@Service
public class UserService {
    
    private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public User createUser(User user) {
        return userRepository.save(user);
    }
    
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
