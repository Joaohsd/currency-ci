package org.example.utils.validation;

import org.example.utils.exceptions.InvalidCurrencyCodeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyValidatorTest {

    private CurrencyValidator _currencyValidator;

    @BeforeEach
    public void setup(){
        _currencyValidator = new CurrencyValidator();
    }

    @Test
    void validateAmount_ValidAmount_DoesNotThrowException() {
        // Given
        double amount = 100.0;

        // When / Then
        _currencyValidator.validateAmount(amount); // Should not throw any exception
    }

    @Test
    void validateAmount_InvalidAmount_ThrowsIllegalArgumentException() {
        // Given
        double amount = -100.0;

        // When / Then
        assertThrows(IllegalArgumentException.class, () -> _currencyValidator.validateAmount(amount));
    }

    @Test
    void validateCurrencyCode_ValidCurrencyCode_DoesNotThrowException() throws InvalidCurrencyCodeException {
        // Given
        String currencyCode = "USD";

        // When / Then
        _currencyValidator.validateCurrencyCode(currencyCode); // Should not throw any exception
    }

    @Test
    void validateCurrencyCode_InvalidCurrencyCode_ThrowsInvalidCurrencyCodeException() {
        // Given
        String currencyCode = "XXX";

        // When / Then
        assertThrows(InvalidCurrencyCodeException.class, () -> _currencyValidator.validateCurrencyCode(currencyCode));
    }

}