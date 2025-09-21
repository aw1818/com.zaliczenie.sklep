package com.zaliczenie.sklep.currency;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class CurrencyRequest {
    private String fromCurrency;
    private String toCurrency;
    private BigDecimal amount;
}
