package com.codecool.marsexploration.data;

import java.util.*;

public class Context {
    private final int timeout;
    private final String[][] map;
    private final Coordinate landing;
    private final Rover rover;
    private final SuccessCondition successCondition;
    private int stepNumber;
    private Optional<Outcome> outcome;
    private Set<Coordinate> nextMoveCoordinates = new HashSet<>();
    private Set<Coordinate> coordinatesAroundRoverSight = new HashSet<>();
    private final Map<Coordinate, String> scannedCoordinates = new HashMap<>();

    public Context(int timeout, String[][] map, Coordinate landing, Rover rover, Optional<Outcome> outcome, SuccessCondition successCondition) {
        this.timeout = timeout;
        this.map = map;
        this.landing = landing;
        this.rover = rover;
        this.outcome = outcome;
        this.successCondition = successCondition;
    }

    public int getTimeout() {
        return timeout;
    }

    public SuccessCondition getSuccessCondition() {
        return successCondition;
    }

    public String[][] getMap() {
        return map;
    }

    public Coordinate getLanding() {
        return landing;
    }

    public Rover getRover() {
        return rover;
    }

    public int getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    public Optional<Outcome> getOutcome() {
        return outcome;
    }

    public void setOutcome(Optional<Outcome> outcome) {
        this.outcome = outcome;
    }

    public Set<Coordinate> getNextMoveCoordinates() {
        return nextMoveCoordinates;
    }

    public void setNextMoveCoordinates(Set<Coordinate> nextMoveCoordinates) {
        this.nextMoveCoordinates = nextMoveCoordinates;
    }

    public void setCoordinatesAroundRoverSight(Set<Coordinate> coordinatesAroundRoverSight) {
        this.coordinatesAroundRoverSight = coordinatesAroundRoverSight;
    }

    public Map<Coordinate, String> getScannedCoordinates() {
        return scannedCoordinates;
    }

    public void putScannedCoordinates(Coordinate coordinate, String symbol) {
        scannedCoordinates.put(coordinate, symbol);
    }
}