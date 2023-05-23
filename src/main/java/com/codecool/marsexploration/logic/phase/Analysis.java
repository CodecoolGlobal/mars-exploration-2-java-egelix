package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Outcome;
import com.codecool.marsexploration.data.Symbol;
import com.codecool.marsexploration.data.rover.FoundResource;

import java.util.Set;

public class Analysis implements Phase {
    private final Set<FoundResource> foundResources;

    public Analysis(Set<FoundResource> foundResources) {
        this.foundResources = foundResources;
    }

    @Override
    public void perform(Context context) {
        Set<Coordinate> scannedCoordinates = context.getScannedFields();
        String[][] map = context.getMap();
        int counterForOutcome = 0;
        for (Coordinate coordinate : scannedCoordinates) {
            String symbol = map[coordinate.y()][coordinate.x()];
            updateFoundResources(coordinate, symbol);
            counterForOutcome = getCounter(counterForOutcome, symbol);
        }
        if (counterForOutcome >= 8) {
            context.setOutcome(Outcome.WRONG_LANDING_COORDINATES);
        }
    }

    private void updateFoundResources(Coordinate coordinate, String symbol) {
        for (FoundResource foundResource : foundResources) {
            if (symbol.equals(foundResource.getSymbol())) {
                foundResource.setAmount(foundResource.getAmount() + 1);
                foundResource.addCoordinate(coordinate);
            }
        }
    }

    private int getCounter(int counterForOutcome, String symbol) {
        if (symbol.equals(Symbol.PIT.getSymbol()) ||
                symbol.equals(Symbol.MOUNTAIN.getSymbol())) {
            counterForOutcome++;
        }
        return counterForOutcome;
    }
}