package com.cashrich.abhiram.Abhiram_Deshpande_CashRich_Assignment.controller;

import com.cashrich.abhiram.Abhiram_Deshpande_CashRich_Assignment.local_services.IUserService;
import com.cashrich.abhiram.Abhiram_Deshpande_CashRich_Assignment.models.JWTRequest;
import com.cashrich.abhiram.Abhiram_Deshpande_CashRich_Assignment.models.JWTResponse;
import com.cashrich.abhiram.Abhiram_Deshpande_CashRich_Assignment.models.SignUpForm;
import com.cashrich.abhiram.Abhiram_Deshpande_CashRich_Assignment.security.JWTUtil;
import com.cashrich.abhiram.Abhiram_Deshpande_CashRich_Assignment.utils.UtilStrings;
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
    public SignUpForm signUp(@RequestBody SignUpForm signUpForm){

        signUpForm.setSuccess(UtilStrings.SUCCESS);
        return signUpForm;

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


    @GetMapping
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
