package com.codecool.marsexploration.data;

import com.codecool.marsexploration.data.rover.Rover;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Context {
    private final int timeout;
    private final String[][] map;
    private final Coordinate landing;
    private final Rover rover;
    private int stepNumber;
    private Optional<Outcome> outcome;
    private List<LogFile> logFile;
    private Set<Coordinate> nextMoveCoordinates;
    private Set<Coordinate> coordinatesAroundRoverSight;

    public Context(int timeout, String[][] map, Coordinate landing, Rover rover, Optional<Outcome> outcome) {
        this.timeout = timeout;
        this.map = map;
        this.landing = landing;
        this.rover = rover;
        this.outcome = outcome;
    }

    public int getTimeout() {
        return timeout;
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

    public List<LogFile> getLogFile() {
        return logFile;
    }

    public void setLogFile(List<LogFile> logFile) {
        this.logFile = logFile;
    }

    public Set<Coordinate> getNextMoveCoordinates() {
        return nextMoveCoordinates;
    }

    public void setNextMoveCoordinates(Set<Coordinate> nextMoveCoordinates) {
        this.nextMoveCoordinates = nextMoveCoordinates;
    }

    public Set<Coordinate> getCoordinatesAroundRoverSight() {
        return coordinatesAroundRoverSight;
    }

    public void setCoordinatesAroundRoverSight(Set<Coordinate> coordinatesAroundRoverSight) {
        this.coordinatesAroundRoverSight = coordinatesAroundRoverSight;
    }
}