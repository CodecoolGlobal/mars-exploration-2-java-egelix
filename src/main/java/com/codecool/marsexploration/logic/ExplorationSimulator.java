package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.SimulationInput;
import com.codecool.marsexploration.data.Symbol;
import com.codecool.marsexploration.data.rover.FoundResource;
import com.codecool.marsexploration.io.Writer;
import com.codecool.marsexploration.logic.analyzer.Analyzer;
import com.codecool.marsexploration.logic.analyzer.LackOfRessourcesAnalyzer;
import com.codecool.marsexploration.logic.analyzer.SuccessAnalyzer;
import com.codecool.marsexploration.logic.analyzer.TimeoutAnalyzer;
import com.codecool.marsexploration.logic.movement.Move;
import com.codecool.marsexploration.logic.movement.RandomMove;
import com.codecool.marsexploration.logic.phase.*;
import com.codecool.marsexploration.ui.Display;
import com.codecool.marsexploration.utility.ContextGenerator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExplorationSimulator {
    private final CoordinateCreator coordinateCreator = new CoordinateCreator();
    private final Display display = new Display();
    private final Writer writer = new Writer();
    private final Move chosenMove = new RandomMove();
    private final Set<FoundResource> foundResources = new HashSet<>(List.of(
            new FoundResource(Symbol.MINERAL.getSymbol(), new HashSet<>()),
            new FoundResource(Symbol.WATER.getSymbol(), new HashSet<>())
    ));
    private final List<Analyzer> analyzers = List.of(
            new SuccessAnalyzer(),
            new TimeoutAnalyzer(),
            new LackOfRessourcesAnalyzer()
    );
    private final List<Phase> phases = List.of(
            new Movement(),
            new Scan(coordinateCreator, foundResources),
            new Analysis(analyzers),
            new Log(display, writer, foundResources),
            new StepIncrement()
    );

    public void simulate(SimulationInput input) {
        ContextGenerator contextGenerator = new ContextGenerator();
        Context context = contextGenerator.generate(input);
        do {
            for (Phase phase : phases) {
                phase.perform(context);
            }
        } while (context.getOutcome().isEmpty());
    }
}