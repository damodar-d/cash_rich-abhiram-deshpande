package com.crypto_rates.config;

import com.crypto_rates.filters.ApiOriginConfirmationHeaderFilter;
import com.crypto_rates.filters.CredentialValidationFilter;
import com.crypto_rates.security.JWTAuthenticationEntryPoint;
import com.crypto_rates.filters.JWTAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private JWTAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    private JWTAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    private ApiOriginConfirmationHeaderFilter apiOriginConfirmationHeaderFilter;

    @Autowired
    private CredentialValidationFilter credentialValidationFilter;
//    @Autowired
//    private HibernateSessionPerRequestFilter hibernateSessionPerRequestFilter;
    @Autowired
    private UserDetailsService userDetailService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


        http
                .csrf(csrf->csrf.disable())
                .cors(cors->cors.disable())

                .authorizeHttpRequests(

                        auth->auth
                        .requestMatchers("/home/**")
                        .authenticated()

                        .requestMatchers("/update/**")
                        .permitAll()

                        .requestMatchers("/auth/**")
                        .permitAll()

                        .anyRequest()
                        .permitAll()
                )
                .exceptionHandling(exception->exception.authenticationEntryPoint(jwtAuthenticationEntryPoint))
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider =new DaoAuthenticationProvider();

        daoAuthenticationProvider.setUserDetailsService(userDetailService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        return daoAuthenticationProvider;
    }
}
