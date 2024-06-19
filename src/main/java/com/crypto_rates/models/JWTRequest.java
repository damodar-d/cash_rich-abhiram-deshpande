package com.crypto_rates.models;

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
