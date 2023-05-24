package com.codecool.marsexploration.data.rover;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.logic.movement.Move;

import java.util.HashSet;
import java.util.Set;

public class Rover {
    private final int id;
    private final int sight;
    private Move move;
    private Coordinate position;
    private Set<Coordinate> coordinatesTracker = new HashSet<>();

    public Rover(int id, Coordinate position, int sight, Move move) {
        this.id = id;
        this.position = position;
        this.sight = sight;
        this.move = move;
    }

    public int getId() {
        return id;
    }

    public int getSight() {
        return sight;
    }

    public Coordinate getPosition() {
        return position;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }

    public Set<Coordinate> getCoordinatesTracker() {
        return coordinatesTracker;
    }

    public void addCoordinatesTracker(Coordinate actualCoordinate) {
        this.coordinatesTracker.add(actualCoordinate);
    }

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }
}