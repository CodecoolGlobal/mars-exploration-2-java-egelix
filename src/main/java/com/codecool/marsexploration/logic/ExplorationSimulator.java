package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.io.Writer;
import com.codecool.marsexploration.logic.analyzer.Analyzer;
import com.codecool.marsexploration.logic.analyzer.LackOfRessourcesAnalyzer;
import com.codecool.marsexploration.logic.analyzer.SuccessAnalyzer;
import com.codecool.marsexploration.logic.analyzer.TimeoutAnalyzer;
import com.codecool.marsexploration.logic.movement.Move;
import com.codecool.marsexploration.logic.movement.RandomMove;
import com.codecool.marsexploration.logic.phase.*;
import com.codecool.marsexploration.ui.Display;

import java.util.List;

public class ExplorationSimulator {
    private final CoordinateCreator coordinateCreator = new CoordinateCreator();
    private final Display display = new Display();
    private final Writer writer = new Writer();
    private final Move chosenMove = new RandomMove();
    private final Context context;
    private final List<Analyzer> analyzers = List.of(
            new SuccessAnalyzer(),
            new TimeoutAnalyzer(),
            new LackOfRessourcesAnalyzer()
    );
    private final List<Phase> phases = List.of(
            new Movement(),
            new Scan(coordinateCreator),
            new Analysis(analyzers),
            new Log(display, writer),
            new StepIncrement()
    );

    public ExplorationSimulator(Context context) {
        this.context = context;
    }

    public void simulate() {

        do {
            for (Phase phase : phases) {
                phase.perform(context);
            }
        } while (context.getOutcome().isEmpty());
    }
}