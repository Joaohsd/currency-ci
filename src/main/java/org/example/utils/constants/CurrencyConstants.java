package org.example.utils.constants;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CurrencyConstants {
    // Create HashSet for currency codes
    public static Set<String> CURRENCY_CODES = new HashSet<>(Arrays.asList(
            "EUR", "USD", "JPY", "BGN", "CZK", "DKK", "GBP", "HUF", "PLN", "RON",
            "SEK", "CHF", "ISK", "NOK", "HRK", "RUB", "TRY", "AUD", "BRL", "CAD",
            "CNY", "HKD", "IDR", "ILS", "INR", "KRW", "MXN", "MYR", "NZD", "PHP",
            "SGD", "THB", "ZAR"
    ));

    public static String DEFAULT_CODE = "USD";
}
