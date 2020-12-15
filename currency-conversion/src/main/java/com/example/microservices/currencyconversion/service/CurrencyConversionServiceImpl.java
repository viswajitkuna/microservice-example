package com.example.microservices.currencyconversion.service;

import com.example.microservices.currencyconversion.dto.CurrencyConversionBean;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CurrencyConversionServiceImpl implements CurrencyConversionService {

    @Override
    public CurrencyConversionBean calculateCurrencyConversion(CurrencyConversionBean currencyConversionBean) {
        BigDecimal totalAmount = currencyConversionBean.getQuantity().multiply(currencyConversionBean.getConversionRate());
        currencyConversionBean.setTotalAmount(totalAmount);
        return currencyConversionBean;
    }
}
