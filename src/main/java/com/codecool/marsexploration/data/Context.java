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


}
