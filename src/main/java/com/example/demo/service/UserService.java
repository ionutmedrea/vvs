package com.example.demo.service;

import com.example.demo.dtos.UserDto;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.model.User;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public User registerUser(User userForm)
    {
        User newUser = new User();
            newUser.setUsername(userForm.getUsername());
            newUser.setPassword(bCryptPasswordEncoder.encode(userForm.getPassword()));
            newUser.setConfirmPassword(bCryptPasswordEncoder.encode(userForm.getConfirmPassword()));
            newUser.setRoles(userForm.getRoles());

        return userRepository.save(newUser);
    }
    public User registerUser(UserDto userForm)
    {
        User newUser = new User();
        newUser.setUsername(userForm.getUsername());
        newUser.setPassword(bCryptPasswordEncoder.encode(userForm.getPassword()));
        newUser.setConfirmPassword(bCryptPasswordEncoder.encode(userForm.getConfirmPassword()));
        newUser.setRoles(userForm.getRoles());

        return userRepository.save(newUser);
    }
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
