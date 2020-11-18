package com.example.demo;

import com.example.demo.exceptions.WrongUsernameOrPasswordException;
import com.example.demo.model.User;
import com.example.demo.validator.UserValidator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserValidatorTest {
    UserValidator userValidator;
    @Test
    public void userNameLessThan6() throws RuntimeException{
        User user = new User();
        user.setUsername("asd");
        user.setPassword("asdasdasd");
        user.setConfirmPassword("asdasdasd");
        user.setRoles("student");
        assertThrows(WrongUsernameOrPasswordException.class, () ->userValidator.validate(user));
    }
    @Test
    public void userNameLessMoreThan32() throws RuntimeException{
        User user = new User();
        user.setUsername("asdasdasdasdasdasdasdasdasdasdasdasd");
        user.setPassword("asdasdasd");
        user.setConfirmPassword("asdasdasd");
        user.setRoles("student");
        assertThrows(WrongUsernameOrPasswordException.class, () ->userValidator.validate(user));
    }
    @Test
    public void passwordDontMatch() throws RuntimeException{
        User user = new User();
        user.setUsername("asdasdasda");
        user.setPassword("asdasdasd");
        user.setConfirmPassword("asdasd");
        user.setRoles("student");
        assertThrows(WrongUsernameOrPasswordException.class, () ->userValidator.validate(user));
    }
    @Test
    public void passwordLessThan8() throws RuntimeException{
        User user = new User();
        user.setUsername("asdasda");
        user.setPassword("asd");
        user.setConfirmPassword("asd");
        user.setRoles("student");
        assertThrows(WrongUsernameOrPasswordException.class, () ->userValidator.validate(user));
    }
    @Test
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
