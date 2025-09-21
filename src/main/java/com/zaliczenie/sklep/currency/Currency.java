package com.zaliczenie.sklep.currency;


import java.util.Arrays;
import java.util.List;

public enum Currency {
    PLN, EUR, USD;

    public static List<String> getAll() {
        return Arrays.stream(Currency.values()).map(Currency::name).toList();
    }
}
