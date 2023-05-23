package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.SimulationInput;
import com.codecool.marsexploration.data.Symbol;
import com.codecool.marsexploration.data.rover.FoundResource;
import com.codecool.marsexploration.logic.phase.*;
import com.codecool.marsexploration.ui.Display;
import com.codecool.marsexploration.utility.ContextGenerator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExplorationSimulator {
    private final CoordinateCreator coordinateCreator = new CoordinateCreator();
    private final Display display = new Display();
    private final Set<FoundResource> foundResources = new HashSet<>(List.of(
            new FoundResource(Symbol.MINERAL.getSymbol(), 0, new HashSet<>()),
            new FoundResource(Symbol.WATER.getSymbol(), 0, new HashSet<>())));

    public void simulate(SimulationInput input) {
        HashSet<Phase> phases = initializePhases();
        ContextGenerator contextGenerator = new ContextGenerator();
        Context context = contextGenerator.generate(input);
        for (Phase phase : phases) {
            phase.perform(context);
        }
    }

    private HashSet<Phase> initializePhases() {
        HashSet<Phase> phases = new HashSet<>();
        phases.add(new Movement());
        phases.add(new Scan(coordinateCreator));
        phases.add(new Analysis(foundResources));
        phases.add(new Log(display, foundResources));
        phases.add(new StepIncrement());
        return phases;
    }
}