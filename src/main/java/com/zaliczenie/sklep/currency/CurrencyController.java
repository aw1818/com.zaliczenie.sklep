package com.zaliczenie.sklep.currency;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/currency")
@AllArgsConstructor
public class CurrencyController {

    private final CurrencyCalculator currencyCalculator;

    @GetMapping("/list")
    public ResponseEntity<Object> getAllCurrencies() {
        return ResponseEntity.ok().body(Currency.getAll());
    }

    @GetMapping("/exchangeRate")
    public ResponseEntity<Object> getExchangeRate(@RequestParam String from, @RequestParam String to) {
        try {
            BigDecimal rate = currencyCalculator.getExchangeRate(Currency.valueOf(from), Currency.valueOf(to));
            return ResponseEntity.ok().body(rate);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }

    @PostMapping("/convert")
    public ResponseEntity<Object> convert(@RequestBody CurrencyRequest currencyRequest) {
        try {
            BigDecimal convertedAmount = currencyCalculator.convert(currencyRequest.getAmount(),
                    Currency.valueOf(currencyRequest.getFromCurrency()),
                    Currency.valueOf(currencyRequest.getToCurrency()));
            return ResponseEntity.ok().body(convertedAmount);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }

}
