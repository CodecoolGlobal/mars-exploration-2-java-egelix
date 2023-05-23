package com.codecool.marsexploration.data;

import com.codecool.marsexploration.data.rover.FoundResource;
import com.codecool.marsexploration.data.rover.Rover;

import java.util.List;
import java.util.Set;

public class Context {
    private final int timeout;
    private final String[][] map;
    private final Coordinate landing;
    private final Rover rover;
    private int stepNumber;
    private Outcome outcome;
    private List<LogFile> logFile;
    private Set<Coordinate> scannedFields;
    private Set<Coordinate> possibleNextMove;
    private Set<FoundResource> foundResources;

    public Context(int timeout, String[][] map, Coordinate landing, Rover rover) {
        this.timeout = timeout;
        this.map = map;
        this.landing = landing;
        this.rover = rover;
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

    public Outcome getOutcome() {
        return outcome;
    }

    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }

    public List<LogFile> getLogFile() {
        return logFile;
    }

    public void setLogFile(List<LogFile> logFile) {
        this.logFile = logFile;
    }

    public Set<Coordinate> getScannedFields() {
        return scannedFields;
    }

    public void setScannedFields(Set<Coordinate> scannedFields) {
        this.scannedFields = scannedFields;
    }

    public Set<Coordinate> getPossibleNextMove() {
        return possibleNextMove;
    }

    public void setPossibleNextMove(Set<Coordinate> possibleNextMove) {
        this.possibleNextMove = possibleNextMove;
    }

    public Set<FoundResource> getFoundResources() {
        return foundResources;
    }

    public void setFoundResources(Set<FoundResource> foundResources) {
        this.foundResources = foundResources;
    }
}