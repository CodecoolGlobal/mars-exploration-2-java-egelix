package com.codecool.marsexploration.logic.movement;

import com.codecool.marsexploration.data.Context;

public interface Move {
    void move(Context context);

    String getName();
}