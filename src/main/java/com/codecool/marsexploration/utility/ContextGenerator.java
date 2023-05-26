package com.codecool.marsexploration.utility;

import com.codecool.marsexploration.data.*;
import com.codecool.marsexploration.io.Reader;
import com.codecool.marsexploration.logic.movement.RandomMove;
import com.codecool.marsexploration.ui.Display;

import java.io.IOException;
import java.util.Optional;
import java.util.Random;

public class ContextGenerator {
    private final Display display;
    private final Random random;
    private final UserInput userInput;
    private final Reader reader;

    public ContextGenerator(Display display, Random random, UserInput userInput, Reader reader) {
        this.display = display;
        this.random = random;
        this.userInput = userInput;
        this.reader = reader;
    }

    public Context generate(SimulationInput input) {
        String[][] map;
        try {
            map = reader.mapReader(input.mapPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Coordinate landing = new Coordinate(random.nextInt(map.length), random.nextInt(map.length));
        map[landing.y()][landing.x()] = Symbol.SPACE_SHIP.getSymbol();
        Rover rover = new Rover(1, landing, userInput.roverSight(), new RandomMove(display, random));
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