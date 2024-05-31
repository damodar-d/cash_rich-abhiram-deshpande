package com.cashrich.abhiram.Abhiram_Deshpande_CashRich_Assignment.config;

import com.cashrich.abhiram.Abhiram_Deshpande_CashRich_Assignment.filters.ApiOriginConfirmationHeaderFilter;
import com.cashrich.abhiram.Abhiram_Deshpande_CashRich_Assignment.filters.CredentialValidationFilter;
import com.cashrich.abhiram.Abhiram_Deshpande_CashRich_Assignment.security.JWTAuthenticationEntryPoint;
import com.cashrich.abhiram.Abhiram_Deshpande_CashRich_Assignment.filters.JWTAuthenticationFilter;
import org.apache.catalina.webresources.CachedResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
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
                        .authenticated()

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
