package com.codecool.marsexploration.data.rover;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.logic.routine.Routine;

import java.util.List;

public class Rover {
    private final int id;
    private final int sight;
    private Routine routine;
    private Coordinate position;
    private List<Coordinate> coordinatesTracker;

    public Rover(int id, Coordinate position, int sight, Routine routine) {
        this.id = id;
        this.position = position;
        this.sight = sight;
        this.routine = routine;
    }

    public Coordinate getPosition() {
        return position;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }

    public List<Coordinate> getCoordinatesTracker() {
        return coordinatesTracker;
    }

    public void setCoordinatesTracker(List<Coordinate> coordinatesTracker) {
        this.coordinatesTracker = coordinatesTracker;
    }

    public Routine getRoutine() {
        return routine;
    }

    public void setRoutine(Routine routine) {
        this.routine = routine;
    }
}