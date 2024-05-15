package com.cashrich.abhiram.Abhiram_Deshpande_CashRich_Assignment.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @PostMapping("/signup")
    public void signUp(@RequestParam String username){

    }
    @PostMapping("/login")
    public void logIn(@RequestParam String username){

    }
}
