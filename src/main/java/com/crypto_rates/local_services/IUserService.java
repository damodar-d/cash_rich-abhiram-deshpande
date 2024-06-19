package com.crypto_rates.local_services;

import com.crypto_rates.entities.User;

public interface IUserService {
    public User getUser(String userName);

    public void updateFirstName(String newFirstName);

    public void updateLastName(String newLastName);

    public void updateMobileNumber(String newMobileNumber);

    public void updatePassword(String newPassword);
}
