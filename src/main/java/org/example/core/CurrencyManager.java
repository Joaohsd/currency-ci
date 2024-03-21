package org.example.core;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import org.example.service.interfaces.CurrencyService;
import org.example.utils.constants.CurrencyConstants;
import org.example.utils.exceptions.InvalidCurrencyCodeException;
import org.example.utils.validation.CurrencyValidator;

import java.util.Set;

public class CurrencyManager {
    private CurrencyService _currencyService;
    private CurrencyValidator _currencyValidator;
    public CurrencyManager(CurrencyService currencyService, CurrencyValidator currencyValidator) {
        _currencyService = currencyService;
        _currencyValidator = currencyValidator;
    }

    public Double convert(Double amount, String fromCurrency, String toCurrency) throws InvalidCurrencyCodeException, IllegalArgumentException {
        // Validate amount provided
        _currencyValidator.validateAmount(amount);

        // Validate codes provided
        _currencyValidator.validateCurrencyCode(fromCurrency);
        _currencyValidator.validateCurrencyCode(toCurrency);

        // Extract exchange values from Json
        Double fromCurrencyExchange = getExchangeRate(fromCurrency);
        Double toCurrencyExchange = getExchangeRate(toCurrency);

        // Return converted value based on amount provided and codes
        return amount * (toCurrencyExchange / fromCurrencyExchange);
    }

    public Set<String> getAvailableCodes(){
        String currenciesJson = _currencyService.getCurrencies();
        JsonObject jsonObject = parseJson(currenciesJson);
        return jsonObject.getAsJsonObject("data").keySet();
    }

    private Double getExchangeRate(String currencyCode){
        String jsonExchangeRate = _currencyService.getLatest(CurrencyConstants.DEFAULT_CODE, currencyCode.toUpperCase());
        return extractExchangeValue(jsonExchangeRate, currencyCode);
    }

    private Double extractExchangeValue(String jsonData, String currencyCode){
        JsonObject jsonObject = parseJson(jsonData);
        return jsonObject.getAsJsonObject("data").get(currencyCode).getAsDouble();
    }

    private JsonObject parseJson(String jsonData) {
        try {
            return JsonParser.parseString(jsonData).getAsJsonObject();
        } catch (JsonParseException e) {
            throw new RuntimeException("Error parsing JSON response: " + e.getMessage());
        }
    }
}
