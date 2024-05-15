package com.cashrich.abhiram.Abhiram_Deshpande_CashRich_Assignment.web_services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FetchCoinDataService {

    @GetMapping("fetch-coin-data")
    public String fetchCoinData(){
        String result="";


        return result;
    }
}
