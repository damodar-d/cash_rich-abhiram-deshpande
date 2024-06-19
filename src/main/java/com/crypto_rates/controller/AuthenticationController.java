package com.crypto_rates.controller;

import com.crypto_rates.local_services.IUserService;
import com.crypto_rates.models.JWTRequest;
import com.crypto_rates.models.JWTResponse;
import com.crypto_rates.models.SignUpForm;
import com.crypto_rates.security.JWTUtil;
import com.crypto_rates.utils.UtilStrings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController("/auth")
public class AuthenticationController {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private IUserService IUserService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JWTUtil helper;

    @PostMapping("/signup")
    @ResponseBody
    public ResponseEntity<String> signUp(@RequestBody SignUpForm signUpForm){

        //String JWT_TOKEN = this.helper.generateToken();
        signUpForm.setSuccess(UtilStrings.SUCCESS);
        return new ResponseEntity<>("Sign Up",HttpStatus.OK);

    }
    @RequestMapping(value = "/login", method = RequestMethod.POST) // Let's try some different way of mapping xD
    public ResponseEntity<JWTResponse> logIn(@RequestBody JWTRequest loginForm){

        this.authenticate(loginForm.getUsername(),loginForm.getPassword());

        UserDetails userDetails = userDetailsService.loadUserByUsername(loginForm.getUsername());
        String token = this.helper.generateToken(userDetails);
        JWTResponse response = JWTResponse.builder()
                .token(token)
                .userName(userDetails.getUsername()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    public String getLoggedInUser(Principal principal){
        return principal.getName();
    }

    private void authenticate(String username, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, password);
        try {
            manager.authenticate(authentication);


        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }
    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Invalid Credentials !";
    }
}
