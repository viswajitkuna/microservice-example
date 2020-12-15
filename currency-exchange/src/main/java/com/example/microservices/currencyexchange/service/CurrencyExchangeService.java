package com.example.microservices.currencyexchange.service;

import com.example.microservices.currencyexchange.dto.CurrencyExchange;

public interface CurrencyExchangeService {

    CurrencyExchange getCurrencyExchange(String from, String to);

}
