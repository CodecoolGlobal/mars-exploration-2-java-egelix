package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.io.ImageGenerator;
import com.codecool.marsexploration.logic.phase.Phase;

import java.util.List;

public class ExplorationSimulator {
    private final Context context;
    private final List<Phase> phases;
    private final ImageGenerator imageGenerator;

    public ExplorationSimulator(Context context, List<Phase> phases, ImageGenerator imageGenerator) {
        this.context = context;
        this.phases = phases;
        this.imageGenerator = imageGenerator;
    }

    public void simulate() {
        do {
            for (Phase phase : phases) {
                phase.perform(context);
            }
        } while (context.getOutcome().isEmpty());
        imageGenerator.generateMapImage();
    }
}