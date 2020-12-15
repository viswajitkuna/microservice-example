package com.example.microservices.currencyconversion.controller;

import com.example.microservices.currencyconversion.dto.CurrencyConversionBean;
import com.example.microservices.currencyconversion.proxy.CurrencyExchangeProxy;
import com.example.microservices.currencyconversion.service.CurrencyConversionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {

    Logger logger = LoggerFactory.getLogger(CurrencyConversionController.class);

    @Autowired
    private CurrencyConversionService currencyConversionService;

    @Autowired
    private CurrencyExchangeProxy currencyExchangeProxy;

    @Autowired
    private Environment environment;

    @GetMapping(path = "/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean getCurrencyConversion(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        logger.info("from: -> {}, to: -> {}, quantity: -> {}", from, to, quantity);
        CurrencyConversionBean currencyConversionBean = currencyExchangeProxy.getCurrencyExchange(from, to);
        logger.info("currency conversion bean: -> {}", currencyConversionBean);
        currencyConversionBean.setQuantity(quantity);
        return currencyConversionService.calculateCurrencyConversion(currencyConversionBean);
    }
}
