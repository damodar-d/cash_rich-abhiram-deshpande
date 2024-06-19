package com.crypto_rates.local_services;

//import com.crypto_rates.entities.User;
//import com.crypto_rates.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;

//@Service
//public class UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    CustomUserDetailService customUserDetailService;
//
//    public User getUser(String userName){
//        return  userRepository.findByUserName(userName);
//    }
//
//    public User createUser(User user){
//
//       return userRepository.save(user);
//    }
//
//    public User updateEmail(String newEmail, String userName){
//        User user = userRepository.findByUserName(userName);
//        user.setEmailId(newEmail);
//        return userRepository.save(user);
//    }
//
//    public User updateFirstName(String newFirstName,String userName){
//        User user = userRepository.findByUserName(userName);
//        user.setFirstName(newFirstName);
//        return userRepository.save(user);
//    }
//
//    public User updateLastName(String newLastName,String userName){
//        User user = userRepository.findByUserName(userName);
//        user.setLastName(newLastName);
//        return userRepository.save(user);
//    }
//
//    public User updatePassword(String newPassword,String userName){
//        User user = userRepository.findByUserName(userName);
//        user.setPassword(newPassword);
//        return userRepository.save(user);
//    }
//    public User updateMobileNumber(String newMobileNumber,String userName){
//        User user = userRepository.findByUserName(userName);
//        user.setMobileNumber(newMobileNumber);
//        return userRepository.save(user);
//    }
//
//}
