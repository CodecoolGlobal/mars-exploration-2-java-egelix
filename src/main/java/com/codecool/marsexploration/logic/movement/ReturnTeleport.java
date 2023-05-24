package com.codecool.marsexploration.logic.movement;

import com.codecool.marsexploration.data.Context;

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