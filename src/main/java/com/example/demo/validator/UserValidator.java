package com.example.demo.validator;

import com.example.demo.exceptions.UsernameAlreadyTakenException;
import com.example.demo.exceptions.WrongUsernameOrPasswordException;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserValidator {

    @Autowired
    private UserService userService;

    public boolean validate(Object o) throws RuntimeException{
        User user = (User) o;
        if(user.getUsername().length()<6 || user.getUsername().length() > 32){
            throw new WrongUsernameOrPasswordException("Wrong username");
        }
        if(userService.findByUsername(user.getUsername())!=null){
            throw new UsernameAlreadyTakenException("Username already taken");
        }
        if(user.getPassword().length() < 8 || user.getPassword().length()>32){
            throw new WrongUsernameOrPasswordException("Wrong password");
        }
        if (!user.getConfirmPassword().equals(user.getPassword())) {
            throw new WrongUsernameOrPasswordException("ConfirmPassword and password don't match");
        }
        return true;
    }
}