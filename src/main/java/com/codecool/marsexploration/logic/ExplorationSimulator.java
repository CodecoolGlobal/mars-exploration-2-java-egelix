package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.io.Writer;
import com.codecool.marsexploration.logic.analyzer.*;
import com.codecool.marsexploration.logic.phase.*;
import com.codecool.marsexploration.ui.Display;

import java.util.List;

public class ExplorationSimulator {
    private final CoordinateCreator coordinateCreator = new CoordinateCreator();
    private final Display display;
    private final Writer writer;
    private final Context context;
    private final List<Analyzer> analyzers = List.of(
            new AlienAnalyzer(),
            new SuccessAnalyzer(),
            new LackOfRessourcesAnalyzer(),
            new TimeoutAnalyzer()
    );

    public ExplorationSimulator(Display display, Writer writer, Context context) {
        this.display = display;
        this.writer = writer;
        this.context = context;
    }

    public void simulate() {
        List<Phase> phases = List.of(
                new Scan(coordinateCreator),
                new Analysis(analyzers),
                new Movement(),
                new Log(display, writer),
                new StepIncrement()
        );
        do {
            for (Phase phase : phases) {
                phase.perform(context);
            }
        } while (context.getOutcome().isEmpty());
    }
}