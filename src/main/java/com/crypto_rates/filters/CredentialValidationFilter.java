package com.crypto_rates.filters;

import jakarta.servlet.http.HttpFilter;
import org.springframework.stereotype.Component;

@Component
public class CredentialValidationFilter extends HttpFilter { //Filter for validation of sign-up credentials
//
//    private String username;
//    private String password;
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//
//        StringBuffer buffer = new StringBuffer();
//        BufferedReader reader = new BufferedReader(request.getReader());
//        while (reader.ready()){
//            buffer.append(reader.readLine());
//        }
//
//        chain.doFilter(request,response);
//    }
}
