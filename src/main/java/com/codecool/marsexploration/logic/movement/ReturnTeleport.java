package com.codecool.marsexploration.logic.movement;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.rover.Rover;

import java.util.Set;

public class ReturnTeleport implements Move{
    private final String name;

    public ReturnTeleport(String name) {
        this.name = name;
    }

    @Override
    public void move(String[][] map, Coordinate landing, Set<Coordinate> scannedFields, Rover rover) {
        rover.setPosition(landing);
    }

    @Override
    public String getName() {
        return name;
    }
}
