package com.crypto_rates.filters;

import com.crypto_rates.utils.UtilStrings;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.json.JSONObject;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Order(1)
@Component
public class ApiOriginConfirmationHeaderFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("----------------");
        System.out.println("Request hit to ApiOriginConfirmationHeaderFilter");
        System.out.println("----------------");
        String headerValue = request.getHeader(UtilStrings.TRUSTED_API_ORIGIN_HEADER_NAME);

        if(headerValue!=null && headerValue.equals(UtilStrings.TRUSTED_API_ORIGIN_HEADER_VALUE)){
            SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = factory.openSession();
            Transaction transaction = session.beginTransaction();
            request.setAttribute("hibernate_session_object",session);
            request.setAttribute("hibernate_transaction_object",transaction);
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


