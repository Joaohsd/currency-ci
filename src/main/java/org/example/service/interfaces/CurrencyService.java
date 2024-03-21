package org.example.service.interfaces;

import java.util.ArrayList;

public interface CurrencyService {
    String getLatest(String baseCurrency);
    String getLatest(String baseCurrency, String currency);
    String getLatest(String baseCurrency, ArrayList<String> currencies);
    String getCurrencies();
}
