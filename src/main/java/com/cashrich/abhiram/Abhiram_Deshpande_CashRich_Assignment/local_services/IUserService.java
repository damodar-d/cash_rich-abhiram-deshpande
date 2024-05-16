package com.cashrich.abhiram.Abhiram_Deshpande_CashRich_Assignment.local_services;

import com.cashrich.abhiram.Abhiram_Deshpande_CashRich_Assignment.entities.User;

public interface IUserService {
    public User getUser(String userName);

    public void updateFirstName(String newFirstName);

    public void updateLastName(String newLastName);

    public void updateMobileNumber(String newMobileNumber);

    public void updatePassword(String newPassword);
}
