package com.codecool.marsexploration;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.SimulationInput;
import com.codecool.marsexploration.data.SuccessCondition;
import com.codecool.marsexploration.logic.ExplorationSimulator;
import com.codecool.marsexploration.ui.Display;
import com.codecool.marsexploration.utility.ContextGenerator;

import java.util.Random;

public class Application {
    public static void main(String[] args) {
        Display display = new Display();
        Random random = new Random();
        SimulationInput input = new SimulationInput(
                "/exploration-1.map",
                100,
                "src/main/resources/exploration-1.log",
                new SuccessCondition(5,5));
        ContextGenerator contextGenerator = new ContextGenerator(display, random);
        Context context = contextGenerator.generate(input);
        ExplorationSimulator simulator = new ExplorationSimulator(context);
        simulator.simulate();
    }
}