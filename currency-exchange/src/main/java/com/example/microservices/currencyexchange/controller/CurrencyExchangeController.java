package com.example.microservices.currencyexchange.controller;

import com.example.microservices.currencyexchange.CurrencyExchangeApplication;
import com.example.microservices.currencyexchange.dto.CurrencyExchange;
import com.example.microservices.currencyexchange.service.CurrencyExchangeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    private static final Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeService currencyExchangeService;

    @GetMapping(path = "/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange getCurrencyExchange(@PathVariable String from, @PathVariable String to) {
        logger.info("from: ->{} to: ->{}", from, to);
        CurrencyExchange currencyExchange = currencyExchangeService.getCurrencyExchange(from, to);
        logger.info("{}", currencyExchange);
        currencyExchange.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        return currencyExchange;
    }

}
