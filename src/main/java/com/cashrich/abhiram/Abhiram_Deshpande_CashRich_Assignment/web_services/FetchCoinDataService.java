package com.cashrich.abhiram.Abhiram_Deshpande_CashRich_Assignment.web_services;

import com.cashrich.abhiram.Abhiram_Deshpande_CashRich_Assignment.utils.UtilStrings;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class FetchCoinDataService {


    private RestTemplate restTemplate;
    @GetMapping("/fetch-coin-data")
    public String fetchCoinData(){

        String result="";
        restTemplate = new RestTemplate();
        HttpHeaders apiHeader = new HttpHeaders();
        apiHeader.set(UtilStrings.API_HEADER_NAME,UtilStrings.API_KEY);
        HttpEntity<String> httpEntity = new HttpEntity<>(apiHeader);
        result = restTemplate.exchange(UtilStrings.FETCH_URI, HttpMethod.GET,httpEntity,String.class).getBody();


        return result;
    }
}
