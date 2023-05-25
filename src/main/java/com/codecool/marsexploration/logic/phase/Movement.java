package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Rover;
import com.codecool.marsexploration.logic.movement.Move;


public class Movement implements Phase {
    @Override
    public void perform(Context context) {
        Rover rover = context.getRover();
        //TODO: implement logic for switching between movement approach/return movement
        Move chosenMove = rover.getMove();
        chosenMove.move(context);
    }
}