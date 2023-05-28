package com.codecool.marsexploration.data.symbol;

public enum Symbols {
    EMPTY(" "),
    MOUNTAIN("^"),
    PIT("#"),
    MINERAL("*"),
    WATER("~"),
    ALIEN("A"),
    SPACE_SHIP("S");

    private final String symbol;

    Symbols(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}