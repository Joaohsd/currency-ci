package org.example.core;

import org.example.service.interfaces.CurrencyService;
import org.example.utils.constants.CurrencyConstants;
import org.example.utils.exceptions.InvalidCurrencyCodeException;
import org.example.utils.validation.CurrencyValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CurrencyManagerTest {
    @Mock
    private CurrencyService _currencyService;
    private CurrencyValidator _currencyValidator;
    private CurrencyManager _currencyManager;

    @BeforeEach
    public void setup(){
        _currencyValidator = new CurrencyValidator();
        _currencyManager = new CurrencyManager(_currencyService, _currencyValidator);
    }

    @Test
    void convert_ValidAmountAndCurrencies_ReturnsCorrectValueEUR() throws InvalidCurrencyCodeException, IllegalArgumentException {
        // Given
        double amount = 100.0;
        String fromCurrency = "USD";
        String toCurrency = "EUR";

        Mockito.when(_currencyService.getLatest(CurrencyConstants.DEFAULT_CODE, fromCurrency)).thenReturn(CurrencyConstants.CURRENCY_JSON_USD);
        Mockito.when(_currencyService.getLatest(CurrencyConstants.DEFAULT_CODE, toCurrency)).thenReturn(CurrencyConstants.CURRENCY_JSON_EUR);

        // When
        double convertedAmount = _currencyManager.convert(amount, fromCurrency, toCurrency);

        // Then
        assertEquals(90.0, convertedAmount); // Assuming exchange rate from USD to EUR is 0.90
    }

    @Test
    void convert_ValidAmountAndCurrencies_ReturnsCorrectValueBRL() throws InvalidCurrencyCodeException, IllegalArgumentException {
        // Given
        double amount = 100.0;
        String fromCurrency = "USD";
        String toCurrency = "BRL";

        Mockito.when(_currencyService.getLatest(CurrencyConstants.DEFAULT_CODE, fromCurrency)).thenReturn(CurrencyConstants.CURRENCY_JSON_USD);
        Mockito.when(_currencyService.getLatest(CurrencyConstants.DEFAULT_CODE, toCurrency)).thenReturn(CurrencyConstants.CURRENCY_JSON_BRL);

        // When
        double convertedAmount = _currencyManager.convert(amount, fromCurrency, toCurrency);

        // Then
        assertEquals(507.0, convertedAmount); // Assuming exchange rate from USD to EUR is 0.90
    }

    @Test
    void convert_InvalidFromCurrency_ThrowsInvalidCurrencyCodeException() {
        // Given
        double amount = 100.0;
        String fromCurrency = "XXX";
        String toCurrency = "EUR";

        // When / Then
        assertThrows(InvalidCurrencyCodeException.class, () -> _currencyManager.convert(amount, fromCurrency, toCurrency));
    }

    @Test
    void convert_InvalidToCurrency_ThrowsInvalidCurrencyCodeException() {
        // Given
        double amount = 100.0;
        String fromCurrency = "EUR";
        String toCurrency = "XXX";

        // When / Then
        assertThrows(InvalidCurrencyCodeException.class, () -> _currencyManager.convert(amount, fromCurrency, toCurrency));
    }

    @Test
    void convert_InvalidResponse_ThrowsRuntimeException() {
        // Given
        double amount = 100.0;
        String fromCurrency = "USD";
        String toCurrency = "EUR";

        Mockito.when(_currencyService.getLatest(CurrencyConstants.DEFAULT_CODE, fromCurrency)).thenReturn("{}");

        // Then
        assertThrows(RuntimeException.class, () -> _currencyManager.convert(amount, fromCurrency, toCurrency));
    }

    @Test
    void getAvailableCodes_InvalidServiceResponse_ReturnsEmptySet() {
        // Given
        Mockito.when(_currencyService.getCurrencies()).thenReturn("{\"data\":{}}");

        // When
        Set<String> availableCodes = _currencyManager.getAvailableCodes();

        // Then
        assertTrue(availableCodes.isEmpty());
    }

    @Test
    void getAvailableCodes_ValidServiceResponse_ReturnsCorrectSet() {
        // Given
        Mockito.when(_currencyService.getCurrencies()).thenReturn(CurrencyConstants.LATEST_JSON);

        // When
        Set<String> availableCodes = _currencyManager.getAvailableCodes();

        // Then
        assertTrue(availableCodes.equals(CurrencyConstants.CURRENCY_CODES));
    }

}