package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.rover.Rover;
import com.codecool.marsexploration.logic.movement.MoveInterface;
import com.codecool.marsexploration.logic.movement.RandomMove;

import java.util.Set;

public class Movement implements Phase{
    MoveInterface chosenMove;

    @Override
    public void perform(Context context) {
        Rover rover = context.getRover();
        String [][] map = context.getMap();
        Coordinate landing = context.getLanding();
        Set<Coordinate> scannedFields = context.getScannedFields();
        chosenMove = new RandomMove();
        //TODO: implement logic for switching between movement approach/return movement
        chosenMove.move(map, landing, scannedFields, rover);

    }

}
