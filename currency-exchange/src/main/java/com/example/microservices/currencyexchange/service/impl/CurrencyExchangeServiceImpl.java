package com.example.microservices.currencyexchange.service.impl;

import com.example.microservices.currencyexchange.dto.CurrencyExchange;
import com.example.microservices.currencyexchange.repository.CurrencyExchangeRepository;
import com.example.microservices.currencyexchange.service.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    @Override
    public CurrencyExchange getCurrencyExchange(String from, String to) {
        return currencyExchangeRepository.findByFromAndTo(from, to);
    }
}
