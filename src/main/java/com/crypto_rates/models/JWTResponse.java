package com.crypto_rates.models;

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
