package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Outcome;
import com.codecool.marsexploration.data.Symbol;
import com.codecool.marsexploration.data.rover.FoundResource;
import com.codecool.marsexploration.data.rover.Rover;
import com.codecool.marsexploration.logic.CoordinateCreator;

import java.util.Optional;
import java.util.Set;

public class Scan implements Phase {
    private final CoordinateCreator coordinateCreator;
    private final Set<FoundResource> foundResources;


    public Scan(CoordinateCreator coordinateCreator, Set<FoundResource> foundResources) {
        this.coordinateCreator = coordinateCreator;
        this.foundResources = foundResources;
    }

    @Override
    public void perform(Context context) {
        Coordinate currentRoverPosition = context.getRover().getPosition();
        String[][] map = context.getMap();
        Set<Coordinate> coordinatesAroundRover = getCoordinatesAroundRover(context, currentRoverPosition, map);
        int counterForOutcome = 0;
        for (Coordinate coordinate : coordinatesAroundRover) {
            String symbol = map[coordinate.y()][coordinate.x()];
            updateFoundResources(coordinate, symbol);
            counterForOutcome = getCounter(counterForOutcome, symbol);
        }
        if (counterForOutcome >= 8) {
            context.setOutcome(Optional.of(Outcome.WRONG_LANDING_COORDINATES));
        }
    }

    private Set<Coordinate> getCoordinatesAroundRover(Context context, Coordinate currentRoverPosition, String[][] map) {
        Rover rover = context.getRover();
        Set<Coordinate> scannedCoordinates = coordinateCreator.aroundRover(currentRoverPosition, map.length, rover.getSight());
        context.setScannedFields(scannedCoordinates);
        return scannedCoordinates;
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