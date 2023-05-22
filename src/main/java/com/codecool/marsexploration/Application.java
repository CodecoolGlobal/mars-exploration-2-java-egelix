package com.codecool.marsexploration;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.SimulationInput;
import com.codecool.marsexploration.logic.ExplorationSimulator;
import com.codecool.marsexploration.logic.analyzer.Analyzer;
import com.codecool.marsexploration.logic.analyzer.SuccessAnalyzer;
import com.codecool.marsexploration.logic.analyzer.TimeoutAnalyzer;
import com.codecool.marsexploration.logic.phase.Analysis;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        List<Analyzer> analyzers = List.of(new TimeoutAnalyzer(),new SuccessAnalyzer(), new LackOfRessourcesAnalyzer());
        Analysis analysis = new Analysis((Analyzer) analyzers);

        ExplorationSimulator simulator = new ExplorationSimulator();
        SimulationInput input = new SimulationInput(
                "src/main/resources/exploration-1.map",
                new Coordinate(12, 12),
                100,
                "src/main/resources/exploration-1.log");
        simulator.simulate(input);
    }
}
