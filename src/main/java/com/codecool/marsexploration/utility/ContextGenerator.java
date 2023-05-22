package com.codecool.marsexploration.utility;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Rover;
import com.codecool.marsexploration.data.SimulationInput;
import com.codecool.marsexploration.logic.routine.Exploring;

public class ContextGenerator {
    public Context generate(SimulationInput input) {
        MapGenerator mapGenerator = new MapGenerator();
        int[][] map = mapGenerator.generate(input.mapPath());
        Rover rover = new Rover(1, input.landing(), 1, new Exploring());
        return new Context(100, map, input.landing(), rover);
    }
}
