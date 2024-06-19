package com.crypto_rates.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "response_table")
public class CryptoBitCoin {

    @Id
    private int id;
    private String name;
    private String symbol;
    private String slug;
    private int numMarketPairs;
    private String dateAdded;

    public CryptoBitCoin(){
        super();
    }
}
