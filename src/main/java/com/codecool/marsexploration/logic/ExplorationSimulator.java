package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.SimulationInput;
import com.codecool.marsexploration.logic.phase.*;
import com.codecool.marsexploration.utility.ContentGenerator;
import com.codecool.marsexploration.utility.ContextGenerator;

import java.util.HashMap;
import java.util.HashSet;

public class ExplorationSimulator {

    public void simulate(SimulationInput input) {
        HashSet<Phase> phases = initializePhases();
        ContextGenerator contextGenerator = new ContextGenerator();
        Context context = contextGenerator.generate(input);
        for(Phase phase: phases) {
            phase.perform(context);
        }
    }

    private HashSet<Phase> initializePhases() {
        HashSet<Phase> phases = new HashSet<>();
        phases.add(new Movement());
        phases.add(new Scan());
        phases.add(new Analysis());
        phases.add(new Log());
        phases.add(new StepIncrement());
        return phases;
    }

}
