package com.example.microservices.currencyconversion.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CurrencyConversionBean {

    private Long id;

    private String from;

    private String to;

    private BigDecimal conversionRate;

    private BigDecimal quantity;

    private BigDecimal totalAmount;

    private Integer port;

}
