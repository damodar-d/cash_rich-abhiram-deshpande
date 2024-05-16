package com.cashrich.abhiram.Abhiram_Deshpande_CashRich_Assignment.controller;

import com.cashrich.abhiram.Abhiram_Deshpande_CashRich_Assignment.entities.User;
import com.cashrich.abhiram.Abhiram_Deshpande_CashRich_Assignment.local_services.IUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/home")
public class FeedController {

    @Autowired
    private IUserServiceImpl userServiceImpl;

    @GetMapping("/get-user/{userName}")
    public User getUser(@PathVariable String userName){
        return userServiceImpl.getUser(userName);
    }
}
