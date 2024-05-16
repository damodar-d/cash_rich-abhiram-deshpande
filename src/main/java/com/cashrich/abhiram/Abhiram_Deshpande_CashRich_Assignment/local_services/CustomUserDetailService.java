package com.cashrich.abhiram.Abhiram_Deshpande_CashRich_Assignment.local_services;

import com.cashrich.abhiram.Abhiram_Deshpande_CashRich_Assignment.entities.User;
import com.cashrich.abhiram.Abhiram_Deshpande_CashRich_Assignment.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUserName(username);
        if(user==null){
            throw new RuntimeException("User not Found");
        }
        return user;
    }
}
