package com.cashrich.abhiram.Abhiram_Deshpande_CashRich_Assignment.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "user_table", indexes = @Index(columnList = "userName"))
public class User implements UserDetails {

    @Id
    private String userName;
    private String emailId;
    private String firstName;
    private String lastName;
    private String password;
    private String mobileNumber;

    public User(String userName, String emailId, String firstName, String lastName, String password, String mobileNumber) {
        this.emailId = emailId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.userName= userName;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
