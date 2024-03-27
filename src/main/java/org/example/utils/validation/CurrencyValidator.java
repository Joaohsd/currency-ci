package org.example.utils.validation;

import org.example.utils.constants.CurrencyConstants;
import org.example.utils.exceptions.InvalidCurrencyCodeException;

public class CurrencyValidator {
    public void validateAmount(Double amount){
        if(amount < 0.0)
            throw new IllegalArgumentException("Illegal argument provided. It must be greater or equal to zero.");
    }

    public void validateCurrencyCode(String currencyCode) throws InvalidCurrencyCodeException {
        if (!CurrencyConstants.CURRENCY_CODES.contains(currencyCode.toUpperCase()))
            throw new InvalidCurrencyCodeException("Invalid currency code provided: " + currencyCode);
    }
}
