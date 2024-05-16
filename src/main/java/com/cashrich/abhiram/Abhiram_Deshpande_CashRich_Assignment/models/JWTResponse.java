package com.cashrich.abhiram.Abhiram_Deshpande_CashRich_Assignment.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class JWTResponse {
    private String token;
    private String userName;
}
