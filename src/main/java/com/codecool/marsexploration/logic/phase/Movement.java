package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Rover;
import com.codecool.marsexploration.logic.movement.Move;

import java.util.Set;

public class Movement implements Phase {
    @Override
    public void perform(Context context) {
        Rover rover = context.getRover();
        String[][] map = context.getMap();
        Coordinate landing = context.getLanding();
        Set<Coordinate> scannedFields = context.getNextMoveCoordinates();
        //TODO: implement logic for switching between movement approach/return movement
        Move chosenMove = rover.getMove();
        chosenMove.move(context);
    }
}