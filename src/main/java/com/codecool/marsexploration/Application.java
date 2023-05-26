package com.codecool.marsexploration;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.SimulationInput;
import com.codecool.marsexploration.data.SuccessCondition;
import com.codecool.marsexploration.data.UserInput;
import com.codecool.marsexploration.io.*;
import com.codecool.marsexploration.logic.CoordinateCreator;
import com.codecool.marsexploration.logic.ExplorationSimulator;
import com.codecool.marsexploration.logic.Place;
import com.codecool.marsexploration.logic.analyzer.*;
import com.codecool.marsexploration.logic.phase.*;
import com.codecool.marsexploration.ui.Display;
import com.codecool.marsexploration.ui.Input;
import com.codecool.marsexploration.utility.ContextGenerator;
import com.codecool.marsexploration.utility.UserInputGenerator;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        int displayLength = 72;
        Display display = new Display(displayLength);
        Input input = new Input(display);
        Random random = new Random();
        Place place = new Place(random);
        ReadFolder readFolder = new ReadFolder();
        Map<Integer, String> getPlanetMapName = readFolder.fromPath("src/main/resources", ".map", display);
        String planetMapPath = "/" + getPlanetMapName.get(random.nextInt(getPlanetMapName.size()));
        UserInputGenerator userInputGenerator = new UserInputGenerator(display, input);
        UserInput userInput = userInputGenerator.getInputs();
        int thresholdRatio = 50;
        SimulationInput simulationInput = new SimulationInput(
                planetMapPath,
                userInput.timeout(),
                "src/main/resources/exploration-1.log",
                new SuccessCondition(userInput.neededMinerals(), userInput.neededWater(), thresholdRatio, thresholdRatio));
        Reader reader = new Reader(); // DIP - Dependency Injection Principle
        ContextGenerator contextGenerator = new ContextGenerator(display, random, userInput, reader);
        Context context = contextGenerator.generate(simulationInput);
        place.randomAlien(context, userInput.amountAliens());
        display.doubleArrayMap(context.getMap(), "Read Map With Alien");
        FolderFileCreator folderFileCreator = new FolderFileCreator(display, readFolder);
        File newFile = folderFileCreator.getDestination();
        LogWriter writer = new LogWriter(newFile);
        ImageGenerator imageGenerator = new ImageGenerator(context);
        CoordinateCreator coordinateCreator = new CoordinateCreator();
        List<Analyzer> analyzers = List.of(
                new AlienAnalyzer(),
                new SuccessAnalyzer(),
                new LackOfRessourcesAnalyzer(),
                new TimeoutAnalyzer()
        );
        List<Phase> phases = List.of(
                new Scan(coordinateCreator),
                new Analysis(analyzers),
                new Movement(),
                new Log(display, writer),
                new StepIncrement()
        );
        ExplorationSimulator simulator = new ExplorationSimulator(context, phases, imageGenerator);
        simulator.simulate();
    }
}