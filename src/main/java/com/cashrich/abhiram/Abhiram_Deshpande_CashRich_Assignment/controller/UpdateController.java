package com.cashrich.abhiram.Abhiram_Deshpande_CashRich_Assignment.controller;

import com.cashrich.abhiram.Abhiram_Deshpande_CashRich_Assignment.entities.User;
import com.cashrich.abhiram.Abhiram_Deshpande_CashRich_Assignment.local_services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateController {

    @Autowired
    private UserServiceImpl userServiceImpl;
    @PostMapping("/update-first-name")
    public void updateFirstName(){

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

    @GetMapping ("/get-user/{userName}")
    public User getUser(@PathVariable String userName){

        return userServiceImpl.getUser(userName);
    }
}
