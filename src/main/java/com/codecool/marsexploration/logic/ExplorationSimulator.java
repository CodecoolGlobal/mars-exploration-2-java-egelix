package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.io.ImageGenerator;
import com.codecool.marsexploration.io.LogWriter;
import com.codecool.marsexploration.logic.analyzer.*;
import com.codecool.marsexploration.logic.phase.*;
import com.codecool.marsexploration.ui.Display;

import java.awt.*;
import java.util.List;
import java.util.Map;

public class ExplorationSimulator {
    private final CoordinateCreator coordinateCreator = new CoordinateCreator();
    private final Display display;
    private final LogWriter writer;
    private final Context context;
    private final List<Analyzer> analyzers = List.of(
            new AlienAnalyzer(),
            new SuccessAnalyzer(),
            new LackOfRessourcesAnalyzer(),
            new TimeoutAnalyzer()
    );
    ImageGenerator imageGenerator;

    public ExplorationSimulator(Display display, LogWriter writer, Context context, ImageGenerator imageGenerator) {
        this.display = display;
        this.writer = writer;
        this.context = context;
        this.imageGenerator = imageGenerator;
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
        imageGenerator.generateMapImage();
    }
}