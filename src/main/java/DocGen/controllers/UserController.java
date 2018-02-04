package DocGen.controllers;

import DocGen.entities.Role;
import DocGen.entities.User;
import DocGen.regs.UserRegistration;
import DocGen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

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

        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        if(pattern.matcher(userRegistration.getUsername()).find())
            return "There should not be any special characters in username!";

        userService.save(new User(userRegistration.getUsername(), userRegistration.getPassword(), Arrays.asList(new Role("USER"))));

        return "User created!";
    }

    @GetMapping(value = "/users")
    public List<User> users() {
        return userService.getAllUsers();
    }

//    @Autowired
//    private TokenStore tokenStore;

//    @GetMapping(value = "/logouts")
//    public void logout(@RequestParam(value = "access_token") String accessToken) {
//        tokenStore.removeAccessToken(tokenStore.readAccessToken(accessToken));
//    }
}
