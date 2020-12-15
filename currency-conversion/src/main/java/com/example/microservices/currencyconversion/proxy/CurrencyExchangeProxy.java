package com.example.microservices.currencyconversion.proxy;

import com.example.microservices.currencyconversion.dto.CurrencyConversionBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "zuul-api-gateway")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeProxy {

    @GetMapping(path = "currency-exchange-service/currency-exchange/from/{from}/to/{to}")
    CurrencyConversionBean getCurrencyExchange(@PathVariable String from, @PathVariable String to);

}
