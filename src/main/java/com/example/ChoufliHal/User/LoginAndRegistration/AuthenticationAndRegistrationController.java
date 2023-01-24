package com.example.ChoufliHal.User.LoginAndRegistration;

import com.example.ChoufliHal.User.LoginAndRegistration.JWT.JwtTokenUtil;
import com.example.ChoufliHal.User.User;
import com.example.ChoufliHal.User.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Optional;

@RestController
@RequestMapping("/")
@Data
@RequiredArgsConstructor
public class AuthenticationAndRegistrationController {

    private AuthenticationManager authenticationManager;
    private final UserService userService;
    //private final JwtTokenUtil jwtTokenUtil;


    @PostMapping(path="register")
    public String createAccount(@RequestBody Registration user, HttpServletRequest request) throws MessagingException, UnsupportedEncodingException {
        Optional<User> existingUser = userService.getUserByUsername(user.getUsername());
        if (existingUser.isPresent())
            return ("user already exists");
        else {
            String siteURL = SiteUtility.getSiteURL(request);
            userService.register(user,siteURL);
            return "<p> You have registered successfully <br> Please check your email to confirm your account <p> ";
        }}

    @GetMapping("/verify")
    public String verifyAccount(@RequestParam("code") String code)
    { boolean verified=userService.verify(code);
        return (verified? "Verification succeeded!" : "Verification failed");
    }


}
