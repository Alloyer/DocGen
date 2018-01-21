package DocGen.controllers;

import DocGen.entities.Role;
import DocGen.entities.User;
import DocGen.regs.UserRegistration;
import DocGen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by alloyer on 11.01.2018.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public String register(@RequestBody UserRegistration userRegistration) {
        if(!userRegistration.getPassword().equals(userRegistration.getPasswordConfirmation()))
            return "Passwords do not match!";
        else if(userService.getUser(userRegistration.getUsername()) != null)
            return "User already exists!";

        //TODO: input sanitization

        userService.save(new User(userRegistration.getUsername(), userRegistration.getPassword(), Arrays.asList(new Role("USER"))));

        return "User created!";
    }

    @GetMapping(value = "/users")
    public List<User> users() {
        return userService.getAllUsers();
    }
}
