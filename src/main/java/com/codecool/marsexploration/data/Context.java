package com.codecool.marsexploration.data;

public class Context {
    int stepNumber;
    int timeout;
    //TODO: property for map
    Coordinate landing;
    Rover rover;
    Outcome outcome;
    //TODO: property for log file

    public Context(int stepNumber, int timeout, Coordinate landing, Rover rover) {
        this.stepNumber = stepNumber;
        this.timeout = timeout;
        this.landing = landing;
        this.rover = rover;
    }


    public int getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public Coordinate getLanding() {
        return landing;
    }

    public void setLanding(Coordinate landing) {
        this.landing = landing;
    }

    public Rover getRover() {
        return rover;
    }

    public void setRover(Rover rover) {
        this.rover = rover;
    }

    public Outcome getOutcome() {
        return outcome;
    }

    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }
}
