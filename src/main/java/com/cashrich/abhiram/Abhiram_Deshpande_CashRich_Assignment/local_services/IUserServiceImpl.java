package com.cashrich.abhiram.Abhiram_Deshpande_CashRich_Assignment.local_services;

import com.cashrich.abhiram.Abhiram_Deshpande_CashRich_Assignment.entities.User;
import org.springframework.stereotype.Service;

@Service
public class IUserServiceImpl implements IUserService {
    private User user;

    public IUserServiceImpl() {
        this.user = new User("ard_1110","designing.developer111@gmail.com","Abhiram","Deshpande","Hehe","9146404087/");
    }

    @Override
    public User getUser(String userName) {
        return this.user;
    }

    @Override
    public void updateFirstName(String newFirstName) {

    }

    @Override
    public void updateLastName(String newLastName) {

    }

    @Override
    public void updateMobileNumber(String newNumber) {

    }

    @Override
    public void updatePassword(String newPassword) {

    }
}
