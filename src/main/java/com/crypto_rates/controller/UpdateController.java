package com.crypto_rates.controller;

import com.crypto_rates.entities.User;
//import com.crypto_rates.local_services.UserService;
import com.crypto_rates.models.UpdateDomainObject;
import com.crypto_rates.security.JWTUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.Session;
import org.hibernate.Transaction;
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

    private Session session ;
    private Transaction transaction ;

//    @Autowired
//    private UserService userService;
    @PostMapping("/update-first-name/{newFirstName}")
    public void updateFirstName(@RequestBody UpdateDomainObject updateDomainObject, HttpServletRequest request){

        String userName = updateDomainObject.getUsername();
        String newFirstName = updateDomainObject.getUpdatedValue();

    }

    @PostMapping("/update-last-name")
    public void updateLastName(@RequestBody UpdateDomainObject updateDomainObject, HttpServletRequest request){
        this.session =  (Session) request.getAttribute("hibernate_session_object");
        this.transaction = (Transaction) request.getAttribute("hibernate_transaction_object");
        String userName = updateDomainObject.getUsername();
        String newLastName = updateDomainObject.getUpdatedValue();
        User user = new User("Pooja","Pooja@gmail.com","Pooja","Deshpande","Password@123","9130998798");
        session.save(user);
        this.transaction.commit();
        this.session.close();

    }

    @PostMapping("/update-mobile-number")
    public void updateMobileNumber(@RequestBody UpdateDomainObject updateDomainObject, HttpServletRequest request){

        System.out.println("Update Mobile Number hit");
        String userName = updateDomainObject.getUsername();
        String newMobileNumber = updateDomainObject.getUpdatedValue();

    }

    @PostMapping("/update-password")
    public void updatePassword(@RequestBody UpdateDomainObject updateDomainObject,HttpServletRequest request){

        String userName;
        String newPassword;
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
