package com.zaliczenie.sklep.currency;

import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

@Service
public class CurrencyCalculator {
    
    private final Map<Currency, Map<Currency, BigDecimal>> exchangeRates;
    
    public CurrencyCalculator() {
        // Initialize exchange rates
        exchangeRates = new HashMap<>();
        
        // PLN rates
        Map<Currency, BigDecimal> plnRates = new HashMap<>();
        plnRates.put(Currency.PLN, BigDecimal.ONE);
        plnRates.put(Currency.EUR, new BigDecimal("0.23")); // 1 PLN = 0.23 EUR
        plnRates.put(Currency.USD, new BigDecimal("0.25")); // 1 PLN = 0.25 USD
        exchangeRates.put(Currency.PLN, plnRates);
        
        // EUR rates
        Map<Currency, BigDecimal> eurRates = new HashMap<>();
        eurRates.put(Currency.PLN, new BigDecimal("4.35")); // 1 EUR = 4.35 PLN
        eurRates.put(Currency.EUR, BigDecimal.ONE);
        eurRates.put(Currency.USD, new BigDecimal("1.09")); // 1 EUR = 1.09 USD
        exchangeRates.put(Currency.EUR, eurRates);
        
        // USD rates
        Map<Currency, BigDecimal> usdRates = new HashMap<>();
        usdRates.put(Currency.PLN, new BigDecimal("4.00")); // 1 USD = 4.00 PLN
        usdRates.put(Currency.EUR, new BigDecimal("0.92")); // 1 USD = 0.92 EUR
        usdRates.put(Currency.USD, BigDecimal.ONE);
        exchangeRates.put(Currency.USD, usdRates);
    }
    

    public BigDecimal convert(BigDecimal amount, Currency fromCurrency, Currency toCurrency) {
        if (amount == null || fromCurrency == null || toCurrency == null) {
            throw new IllegalArgumentException("Amount and currencies cannot be null");
        }
        
        if (fromCurrency == toCurrency) {
            return amount;
        }
        
        BigDecimal rate = exchangeRates.get(fromCurrency).get(toCurrency);
        return amount.multiply(rate).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getExchangeRate(Currency fromCurrency, Currency toCurrency) {
        if (fromCurrency == null || toCurrency == null) {
            throw new IllegalArgumentException("Currencies cannot be null");
        }
        
        return exchangeRates.get(fromCurrency).get(toCurrency);
    }
}
