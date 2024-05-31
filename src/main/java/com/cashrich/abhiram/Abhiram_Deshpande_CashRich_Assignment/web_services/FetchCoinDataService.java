package com.cashrich.abhiram.Abhiram_Deshpande_CashRich_Assignment.web_services;

import com.cashrich.abhiram.Abhiram_Deshpande_CashRich_Assignment.entities.User;
import com.cashrich.abhiram.Abhiram_Deshpande_CashRich_Assignment.utils.UtilStrings;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import jakarta.servlet.http.HttpServletRequest;
import jdk.jfr.ContentType;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.HTTP;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
public class FetchCoinDataService {

    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/fetch-coin-data")
    public ResponseEntity<String> fetchCoinData(@RequestParam Map<String, String>qParams) {

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set(UtilStrings.THIRD_PARTY_API_HEADER_NAME,UtilStrings.API_KEY);
        HttpEntity<String> requestEntity = new HttpEntity<>(requestHeaders);
        StringBuffer buffer = new StringBuffer(UtilStrings.FETCH_URI_PLAIN);
        qParams.forEach((parameter, value)->buffer.append(value+",") );
        String requiredUrl = buffer.toString();
        ResponseEntity<String>responseEntity = restTemplate.exchange(requiredUrl, HttpMethod.GET,requestEntity,String.class);
        String body = responseEntity.getBody();
        JSONObject jsonObject = new JSONObject(body).getJSONObject("data");
        ArrayList<JSONObject>objects= new ArrayList<>();
        Iterator<String> iterator =jsonObject.keys();
        JSONObject rootJSONObject = new JSONObject();
        JSONObject dataJSonObject = new JSONObject();
        while (iterator.hasNext()){{
                objects.add(jsonObject.getJSONObject(iterator.next()));
            }
            objects.forEach(jobject-> {
                String name= jobject.getString("name");
                String symbol = jobject.getString("symbol");
                double price = Double.parseDouble(jobject.getJSONObject("quote").getJSONObject("USD").get("price").toString());
                JSONObject innerJsonObject = new JSONObject();
                innerJsonObject.put("name",name);
                innerJsonObject.put("price",price);
                dataJSonObject.put(symbol,innerJsonObject);
            });
            rootJSONObject.put("data",dataJSonObject);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","application/json");
        return new ResponseEntity<>(rootJSONObject.toString(),headers,HttpStatus.OK);
    }
}
