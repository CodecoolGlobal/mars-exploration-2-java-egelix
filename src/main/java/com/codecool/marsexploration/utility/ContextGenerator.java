package com.codecool.marsexploration.utility;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.SimulationInput;
import com.codecool.marsexploration.data.rover.Rover;
import com.codecool.marsexploration.io.Reader;
import com.codecool.marsexploration.logic.movement.RandomMove;
import com.codecool.marsexploration.logic.routine.Exploring;

import java.io.IOException;
import java.util.Optional;

public class ContextGenerator {
    public Context generate(SimulationInput input) {
        Reader reader = new Reader();
        String[][] map;
        try {
            map = reader.mapReader(input.mapPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Rover rover = new Rover(1, input.landing(), 1, new RandomMove());

        return new Context(
                input.timeout(),
                map,
                input.landing(),
                rover,
                Optional.empty(),
                input.condition()
        );
    }
}