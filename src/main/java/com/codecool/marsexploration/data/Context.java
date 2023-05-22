package com.codecool.marsexploration.data;

import com.codecool.marsexploration.data.rover.FoundResources;
import com.codecool.marsexploration.data.rover.Rover;

import java.util.List;
import java.util.Set;

public class Context {
    private final int timeout;
    private final int[][] map;
    private final Coordinate landing;
    private final Rover rover;

    public int getStepNumber() {
        return stepNumber;
    }

    private int stepNumber;
    private Outcome outcome;
    private List<LogFile> logFile;
    private Set<Coordinate> possibleNextMove;
    private Set<FoundResources> foundResources;

    public Context(int timeout, int[][] map, Coordinate landing, Rover rover) {
        this.timeout = timeout;
        this.map = map;
        this.landing = landing;
        this.rover = rover;
    }

    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }

    public int getTimeout() {
        return timeout;
    }

    public int getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    public List<LogFile> getLogFile() {
        return logFile;
    }

    public void setLogFile(List<LogFile> logFile) {
        this.logFile = logFile;
    }

    public Set<Coordinate> getPossibleNextMove() {
        return possibleNextMove;
    }

    public void setPossibleNextMove(Set<Coordinate> possibleNextMove) {
        this.possibleNextMove = possibleNextMove;
    }

    public Set<FoundResources> getFoundResources() {
        return foundResources;
    }

    public void setFoundResources(Set<FoundResources> foundResources) {
        this.foundResources = foundResources;
    }
}