package com.crypto_rates.controller;

import com.crypto_rates.entities.User;
import com.crypto_rates.local_services.IUserServiceImpl;
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
