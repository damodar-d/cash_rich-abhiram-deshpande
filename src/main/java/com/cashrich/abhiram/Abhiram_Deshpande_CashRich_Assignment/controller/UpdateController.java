package com.cashrich.abhiram.Abhiram_Deshpande_CashRich_Assignment.controller;

import com.cashrich.abhiram.Abhiram_Deshpande_CashRich_Assignment.local_services.IUserServiceImpl;
import com.cashrich.abhiram.Abhiram_Deshpande_CashRich_Assignment.local_services.UserService;
import com.cashrich.abhiram.Abhiram_Deshpande_CashRich_Assignment.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController()
@RequestMapping("/update")
public class UpdateController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JWTUtil helper;
    @Autowired
    private UserService userService;
    @PostMapping("/update-first-name/{newFirstName}")
    public void updateFirstName(@RequestParam  String newFirstName){




    }

    @PostMapping("/update-last-name")
    public void updateLastName(){

    }

    @PostMapping("/update-mobile-number")
    public void updateMobileNumber(){

    }

    @PostMapping("/update-password")
    public void updatePassword(){

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

    public String getLoggedInUser(Principal principal){
        return principal.getName();
    }
}
