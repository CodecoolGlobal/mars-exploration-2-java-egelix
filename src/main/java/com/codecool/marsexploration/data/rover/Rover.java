package com.codecool.marsexploration.data.rover;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Symbol;
import com.codecool.marsexploration.logic.movement.Move;
import com.codecool.marsexploration.logic.routine.Routine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rover {
    private final int id;
    private final int sight;
    private Move move;
    private Coordinate position;
    private HashMap<Coordinate, String> coordinatesTracker;

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

    public HashMap<Coordinate, String> getCoordinatesTracker() {
        return coordinatesTracker;
    }

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }
}