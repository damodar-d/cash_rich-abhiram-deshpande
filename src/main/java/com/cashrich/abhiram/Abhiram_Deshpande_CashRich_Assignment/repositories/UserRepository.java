package com.cashrich.abhiram.Abhiram_Deshpande_CashRich_Assignment.repositories;

import com.cashrich.abhiram.Abhiram_Deshpande_CashRich_Assignment.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    public User findByUserName(String username);
}
