package com.codecool.marsexploration.utility;

import com.codecool.marsexploration.data.*;
import com.codecool.marsexploration.data.symbol.Symbols;
import com.codecool.marsexploration.logic.movement.RandomMove;
import com.codecool.marsexploration.ui.Display;

import java.util.Optional;
import java.util.Random;

public class ContextGenerator {
    private final Display display;
    private final Random random;
    private final UserInput userInput;
    private final String[][] map;

    public ContextGenerator(Display display, Random random, UserInput userInput, String[][] map) {
        this.display = display;
        this.random = random;
        this.userInput = userInput;
        this.map = map;
    }

    public Context generate(int thresholdRatio) {
        Coordinate landing = new Coordinate(random.nextInt(map.length), random.nextInt(map.length));
        map[landing.y()][landing.x()] = Symbols.SPACE_SHIP.getSymbol();
        Rover rover = new Rover(1, landing, userInput.roverSight(), new RandomMove(display, random));
        return new Context(
                userInput.timeout(),
                map,
                landing,
                rover,
                Optional.empty(),
                new SuccessCondition(userInput.neededMinerals(), userInput.neededWater(), thresholdRatio, thresholdRatio)
        );
    }
}