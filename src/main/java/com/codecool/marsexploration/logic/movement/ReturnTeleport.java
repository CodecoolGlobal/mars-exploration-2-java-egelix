package com.codecool.marsexploration.logic.movement;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.rover.Rover;

import java.util.Set;

public class ReturnTeleport implements Move{

    @Override
    public void move(Context context) {
        context.getRover().setPosition(context.getLanding());
    }

    @Override
    public String getName() {
        return "Teleport back to Space Ship";
    }
}