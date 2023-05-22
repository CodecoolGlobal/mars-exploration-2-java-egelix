package com.codecool.marsexploration.data;

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

    public Context(int timeout, int[][] map, Coordinate landing, Rover rover) {
        this.timeout = timeout;
        this.map = map;
        this.landing = landing;
        this.rover = rover;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }

    public void setLogFile(List<LogFile> logFile) {
        this.logFile = logFile;
    }
}