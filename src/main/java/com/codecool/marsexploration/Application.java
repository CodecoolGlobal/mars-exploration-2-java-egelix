package com.codecool.marsexploration;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.SimulationInput;
import com.codecool.marsexploration.data.SuccessCondition;
import com.codecool.marsexploration.logic.ExplorationSimulator;
import com.codecool.marsexploration.utility.ContextGenerator;

public class Application {
    public static void main(String[] args) {
        SimulationInput input = new SimulationInput(
                "src/main/resources/exploration-1.map",
                new Coordinate(12, 12),
                100,
                "src/main/resources/exploration-1.log",
                new SuccessCondition(5,5));
        ContextGenerator contextGenerator = new ContextGenerator();
        Context context = contextGenerator.generate(input);
        ExplorationSimulator simulator = new ExplorationSimulator(context);
        simulator.simulate();
    }
}