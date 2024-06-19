package com.crypto_rates.local_services;

//import com.crypto_rates.entities.User;
//import com.crypto_rates.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Primary;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;

//@Service
//@Primary
//public class CustomUserDetailService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        User user = userRepository.findByUserName(username);
//        if(user==null){
//            throw new RuntimeException("User not Found");
//        }
//        return user;
//    }
//}
