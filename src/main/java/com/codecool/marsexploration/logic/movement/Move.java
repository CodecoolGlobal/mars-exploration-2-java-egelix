package com.codecool.marsexploration.logic.movement;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.rover.Rover;

import java.util.Set;

public interface Move {
    void move(Context context);

    String getName();
}