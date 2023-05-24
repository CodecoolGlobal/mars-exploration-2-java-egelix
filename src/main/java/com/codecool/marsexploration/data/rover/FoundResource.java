package com.codecool.marsexploration.data.rover;

import com.codecool.marsexploration.data.Coordinate;

import java.util.Set;

public class FoundResource {
    private final String symbol;
    private Set<Coordinate> coordinate;

    public FoundResource(String symbol, Set<Coordinate> coordinate) {
        this.symbol = symbol;
        this.coordinate = coordinate;
    }

    public String getSymbol() {
        return symbol;
    }

    public Set<Coordinate> getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Set<Coordinate> coordinate) {
        this.coordinate = coordinate;
    }

    public void addCoordinate(Coordinate coordinate) {
        this.coordinate.add(coordinate);
    }
}