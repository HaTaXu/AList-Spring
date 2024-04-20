package com.example.alist.service;

import com.example.alist.model.User;
import com.example.alist.repository.UserRepository;
import com.example.alist.util.GenerateRandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void initUser(String[] args) throws Exception {
        User admin = userRepository.getUserByRole(User.ADMIN);
        String adminPassword = GenerateRandomString.randomString(8);
        if (args.length > 0) {
            String[] argStr = args[0].split("=");
            if (argStr.length > 1) {
                adminPassword = argStr[1].trim();
            }
        }
        if (admin == null) {
            System.out.println("Admin has been created");
        } else {
            String adminSalt = GenerateRandomString.randomString(16);
        }
    }
}
