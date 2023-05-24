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
        Set<Coordinate> nextMoveCoordinates = coordinateCreator.aroundRover(currentRoverPosition, map.length, 1);
        context.setNextMoveCoordinates(nextMoveCoordinates);
        setOutcomeToWrongLandingIfNextMoveNotPossible(context, map, nextMoveCoordinates);
        updateFoundResourcesWitScanOfRoverSight(context, currentRoverPosition, map);
    }

    private void setOutcomeToWrongLandingIfNextMoveNotPossible(Context context, String[][] map, Set<Coordinate> nextMoveCoordinates) {
        int counterForOutcome = 0;
        for (Coordinate coordinate : nextMoveCoordinates) {
            String symbol = map[coordinate.y()][coordinate.x()];
            counterForOutcome = getCounter(counterForOutcome, symbol);
        }
        if (counterForOutcome >= 8) {
            context.setOutcome(Optional.of(Outcome.WRONG_LANDING_COORDINATES));
        }
    }

    private int getCounter(int counterForOutcome, String symbol) {
        if (symbol.equals(Symbol.PIT.getSymbol()) ||
                symbol.equals(Symbol.MOUNTAIN.getSymbol())) {
            counterForOutcome++;
        }
        return counterForOutcome;
    }

    private void updateFoundResourcesWitScanOfRoverSight(Context context, Coordinate currentRoverPosition, String[][] map) {
        Rover rover = context.getRover();
        Set<Coordinate> coordinatesAroundRoverSight = coordinateCreator.aroundRover(currentRoverPosition, map.length, rover.getSight());
        context.setCoordinatesAroundRoverSight(coordinatesAroundRoverSight);
        for (Coordinate coordinate : coordinatesAroundRoverSight) {
            String symbol = map[coordinate.y()][coordinate.x()];
            updateFoundResources(coordinate, symbol);
        }
    }

    private void updateFoundResources(Coordinate coordinate, String symbol) {
        for (FoundResource foundResource : foundResources) {
            if (symbol.equals(foundResource.getSymbol())) {
                foundResource.addCoordinate(coordinate);
            }
        }
    }
}