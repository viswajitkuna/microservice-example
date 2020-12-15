package com.example.microservices.currencyconversion.service;

import com.example.microservices.currencyconversion.dto.CurrencyConversionBean;

public interface CurrencyConversionService {

    CurrencyConversionBean calculateCurrencyConversion(CurrencyConversionBean currencyConversionBean);

}
