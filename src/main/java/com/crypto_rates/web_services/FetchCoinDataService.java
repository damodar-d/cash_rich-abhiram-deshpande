package com.crypto_rates.web_services;

import com.crypto_rates.utils.UtilStrings;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Iterator;
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
