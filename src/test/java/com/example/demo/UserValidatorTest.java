package com.example.demo;

import com.example.demo.exceptions.WrongUsernameOrPasswordException;
import com.example.demo.model.User;
import com.example.demo.validator.UserValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserValidatorTest {
    @Autowired
    UserValidator userValidator;
    @Test
    @DisplayName("Username length is less than 6 -> Exception")
    public void userNameLessThan6() throws RuntimeException{
        User user = new User();
        user.setUsername("asd");
        user.setPassword("asdasdasd");
        user.setConfirmPassword("asdasdasd");
        user.setRoles("student");
        assertThrows(WrongUsernameOrPasswordException.class, () ->userValidator.validate(user));
    }
    @Test
    @DisplayName("Username length is more than 32 -> Exception")
    public void userNameLessMoreThan32() throws RuntimeException{
        User user = new User();
        user.setUsername("asdasdasdasdasdasdasdasdasdasdasdasd");
        user.setPassword("asdasdasd");
        user.setConfirmPassword("asdasdasd");
        user.setRoles("student");
        assertThrows(WrongUsernameOrPasswordException.class, () ->userValidator.validate(user));
    }
    @Test
    @DisplayName("Password and confirmPassword don't match -> Exception")
    public void passwordDontMatch() throws RuntimeException{
        User user = new User();
        user.setUsername("asdasdasda");
        user.setPassword("asdasdasd");
        user.setConfirmPassword("asdasd");
        user.setRoles("student");
        assertThrows(WrongUsernameOrPasswordException.class, () ->userValidator.validate(user));
    }
    @Test
    @DisplayName("Password length is less than 8 -> Exception")
    public void passwordLessThan8() throws RuntimeException{
        User user = new User();
        user.setUsername("asdasda");
        user.setPassword("asd");
        user.setConfirmPassword("asd");
        user.setRoles("student");
        assertThrows(WrongUsernameOrPasswordException.class, () ->userValidator.validate(user));
    }
    @Test
    @DisplayName("The register parameters meet the required specifications -> Exception")
    public void passingTest(){
        User user = new User();
        user.setUsername("asdasdasd");
        user.setPassword("asdasdasd");
        user.setConfirmPassword("asdasdasd");
        user.setRoles("student");
        userValidator.validate(user);
        //assertEquals()
    }

}
