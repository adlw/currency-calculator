package com.company;

public class Currencies {
    private String code;
    private double rate;
    Currencies (String currency, double rate){
        this.code = currency;
        this.rate = rate;
    }

    public String getCode(){ return code; }
    public double getRate(){ return rate; }
}
