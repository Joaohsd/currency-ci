package org.example.entity;

public class Currency {
    private String symbol;
    private String name;
    private String symbolNative;
    private int decimalDigits;
    private int rounding;
    private String code;
    private String namePlural;
    private String type;
    private double exchangeRate;

    // Constructor for all properties except exchangeRate
    public Currency(String symbol, String name, String symbolNative, int decimalDigits, int rounding, String code, String namePlural, String type) {
        this.symbol = symbol;
        this.name = name;
        this.symbolNative = symbolNative;
        this.decimalDigits = decimalDigits;
        this.rounding = rounding;
        this.code = code;
        this.namePlural = namePlural;
        this.type = type;
    }

    // Constructor for code and exchangeRate
    public Currency(String code, double exchangeRate) {
        this.code = code;
        this.exchangeRate = exchangeRate;
    }

    // Getters and setters
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbolNative() {
        return symbolNative;
    }

    public void setSymbolNative(String symbolNative) {
        this.symbolNative = symbolNative;
    }

    public int getDecimalDigits() {
        return decimalDigits;
    }

    public void setDecimalDigits(int decimalDigits) {
        this.decimalDigits = decimalDigits;
    }

    public int getRounding() {
        return rounding;
    }

    public void setRounding(int rounding) {
        this.rounding = rounding;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNamePlural() {
        return namePlural;
    }

    public void setNamePlural(String namePlural) {
        this.namePlural = namePlural;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "symbol='" + symbol + '\'' +
                ", name='" + name + '\'' +
                ", symbolNative='" + symbolNative + '\'' +
                ", decimalDigits=" + decimalDigits +
                ", rounding=" + rounding +
                ", code='" + code + '\'' +
                ", namePlural='" + namePlural + '\'' +
                ", type='" + type + '\'' +
                ", exchangeRate=" + exchangeRate +
                '}';
    }
}
