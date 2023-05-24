package com.codecool.marsexploration.utility;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.SimulationInput;
import com.codecool.marsexploration.data.Rover;
import com.codecool.marsexploration.io.Reader;
import com.codecool.marsexploration.logic.movement.RandomMove;
import com.codecool.marsexploration.ui.Display;

import java.io.IOException;
import java.util.Optional;
import java.util.Random;

public class ContextGenerator {
    private final Display display;
    private final Random random;

    public ContextGenerator(Display display, Random random) {
        this.display = display;
        this.random = random;
    }

    public Context generate(SimulationInput input) {
        Reader reader = new Reader();
        String[][] map;
        try {
            map = reader.mapReader(input.mapPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Coordinate landing = new Coordinate(random.nextInt(map.length), random.nextInt(map.length));
        Rover rover = new Rover(1, landing, random.nextInt(1, 3), new RandomMove(display, random));
        return new Context(
                input.timeout(),
                map,
                landing,
                rover,
                Optional.empty(),
                input.condition()
        );
    }
}