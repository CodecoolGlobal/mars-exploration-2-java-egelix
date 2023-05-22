package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Outcome;
import com.codecool.marsexploration.data.Symbol;
import com.codecool.marsexploration.data.rover.FoundResource;

import java.util.HashSet;
import java.util.Set;

public class Analysis implements Phase {
    @Override
    public void perform(Context context) {
        Set<Coordinate> scannedCoordinates = context.getScannedFields();
        String[][] map = context.getMap();
        Set<Coordinate> possibleNextMove = new HashSet<>();
        Set<FoundResource> foundResources = new HashSet<>();
        int counterForOutcome = 0;
        for (Coordinate coordinate : scannedCoordinates) {
            String symbol = map[coordinate.y()][coordinate.x()];
            addPossibleNextMove(context, possibleNextMove, coordinate, symbol);
            addFoundResources(context, foundResources, coordinate, symbol);
            counterForOutcome = getCounter(counterForOutcome, symbol);
        }
        if (counterForOutcome >= 8) {
            context.setOutcome(Outcome.WRONG_LANDING_COORDINATES);
        }
    }

    private void addPossibleNextMove(Context context, Set<Coordinate> possibleNextMove, Coordinate coordinate, String symbol) {
        if (symbol.equals(Symbol.EMPTY.getSymbol())) {
            possibleNextMove.add(coordinate);
        }
        context.setPossibleNextMove(possibleNextMove);
    }

    private void addFoundResources(Context context, Set<FoundResource> foundResources, Coordinate coordinate, String symbol) {
        if (symbol.equals(Symbol.MINERAL.getSymbol()) ||
                symbol.equals(Symbol.WATER.getSymbol())) {
            FoundResource foundResource = new FoundResource(symbol, coordinate);
            foundResources.add(foundResource);
        }
        context.setFoundResources(foundResources);
    }

    private int getCounter(int counterForOutcome, String symbol) {
        if (symbol.equals(Symbol.PIT.getSymbol()) ||
                symbol.equals(Symbol.MOUNTAIN.getSymbol())) {
            counterForOutcome++;
        }
        return counterForOutcome;
    }
}