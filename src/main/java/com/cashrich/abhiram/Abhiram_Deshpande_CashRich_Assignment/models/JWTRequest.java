package com.cashrich.abhiram.Abhiram_Deshpande_CashRich_Assignment.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class JWTRequest {

    private String username;
    private String password;
}
