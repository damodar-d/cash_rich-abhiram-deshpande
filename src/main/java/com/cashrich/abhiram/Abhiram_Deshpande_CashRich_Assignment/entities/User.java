package com.cashrich.abhiram.Abhiram_Deshpande_CashRich_Assignment.entities;


import com.cashrich.abhiram.Abhiram_Deshpande_CashRich_Assignment.utils.UtilStrings;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
    @Pattern(regexp = "^[A-Za-z]+$" , message = "Name must contain only characters")
    @Size(min = 4, max = 15, message = "Name must be between 4 and 15 characters")
    private String userName;
    private String emailId;
    private String firstName;
    private String lastName;
    @Size(min = 8, max = 15, message = "Password length must be between 8 and 15 characters")
//    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[@$!%*?&])(?=.*\\d)[A-Za-z\\d@$!%*?&]$",
//            message = "Password should have least 1 upper, 1 lower, 1 digit and 1 special character")
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
