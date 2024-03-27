package org.example;

import org.example.core.CurrencyManager;
import org.example.service.implementations.CurrencyDAO;
import org.example.service.interfaces.CurrencyService;
import org.example.utils.exceptions.InvalidCurrencyCodeException;
import org.example.utils.validation.CurrencyValidator;

public class Main {
    public static void main(String[] args) {

        // Check if there are enough arguments
        if (args.length != 3) {
            System.out.println("Run: java -jar out/file.jar <value> <from_code> <to_code>");
            return;
        }
        
        // Parse arguments
        double value;
        try {
            value = Double.parseDouble(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid value format");
            return;
        }
        String fromCode = args[1];
        String toCode = args[2];

        CurrencyDAO currencyDAO = new CurrencyDAO();
        CurrencyValidator currencyValidator = new CurrencyValidator();
        CurrencyManager currencyManager = new CurrencyManager(currencyDAO, currencyValidator);

        // Invoke convert method
        try{
            double result = currencyManager.convert(value, fromCode, toCode);
            System.out.println("Converted value: " + result);
        } catch (InvalidCurrencyCodeException e){
            e.printStackTrace();
        }
        
    }
}