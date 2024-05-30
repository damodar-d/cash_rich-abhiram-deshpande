package com.cashrich.abhiram.Abhiram_Deshpande_CashRich_Assignment.security;

import com.cashrich.abhiram.Abhiram_Deshpande_CashRich_Assignment.utils.UtilStrings;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(1)
public class ApiOriginConfirmationHeaderFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        String headerValue = request.getHeader(UtilStrings.THIRD_PARTY_API_HEADER_NAME);
        if(headerValue.equals(UtilStrings.TRUSTED_API_ORIGIN_HEADER_VALUE)){
            chain.doFilter(request,response);
        }
        else {
            response.setStatus(400);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("ERR_INVALID_ORIGIN_HEADER","An invalid API origin header is sent");
            jsonObject.put("DESCRIPTION","This API origin header was not set by API");

            response.getWriter().write(jsonObject.toString());
            response.getWriter().flush();

        }

    }
}
