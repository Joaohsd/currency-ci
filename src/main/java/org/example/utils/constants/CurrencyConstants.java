package org.example.utils.constants;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CurrencyConstants {
    // Create HashSet for currency codes
    public static final Set<String> CURRENCY_CODES = new HashSet<>(Arrays.asList(
            "EUR", "USD", "JPY", "BGN", "CZK", "DKK", "GBP", "HUF", "PLN", "RON",
            "SEK", "CHF", "ISK", "NOK", "HRK", "RUB", "TRY", "AUD", "BRL", "CAD",
            "CNY", "HKD", "IDR", "ILS", "INR", "KRW", "MXN", "MYR", "NZD", "PHP",
            "SGD", "THB", "ZAR"
    ));

    public static final String DEFAULT_CODE = "USD";

    public static final String CURRENCY_JSON_BRL = "{ \"data\": { \"BRL\": 5.07 } }";
    public static final String CURRENCY_JSON_USD = "{ \"data\": { \"USD\": 1.00 } }";
    public static final String CURRENCY_JSON_EUR = "{ \"data\": { \"EUR\": 0.90 } }";
    public static final String CURRENCY_JSON_INVALID = "{ \"data\": { \"XXX\": 0.0 } }";

    public static final String LATEST_JSON = "{\"data\":{\"AUD\":1.5154102218,\"BGN\":1.786860323,\"BRL\":4.9735607502,\"CAD\":1.3470202542,\"CHF\":0.8854301723,\"CNY\":7.1517010157,\"CZK\":22.9988133863,\"DKK\":6.8170311921,\"EUR\":0.9142101729,\"GBP\":0.7813501173,\"HKD\":7.8216814735,\"HRK\":6.614490876,\"HUF\":359.6848532786,\"IDR\":15591.873136818,\"ILS\":3.6465604156,\"INR\":83.0744656723,\"ISK\":135.8380875278,\"JPY\":150.7430869771,\"KRW\":1327.1582314717,\"MXN\":16.6724726486,\"MYR\":4.7077406337,\"NOK\":10.5472619612,\"NZD\":1.6417102247,\"PHP\":55.8369891785,\"PLN\":3.9403407761,\"RON\":4.5457409051,\"RUB\":91.3895648308,\"SEK\":10.3648914189,\"SGD\":1.3386401454,\"THB\":35.9517660186,\"TRY\":32.404364381,\"USD\":1,\"ZAR\":18.691873348}}";


}
