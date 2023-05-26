package com.codecool.marsexploration;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.SimulationInput;
import com.codecool.marsexploration.data.SuccessCondition;
import com.codecool.marsexploration.data.UserInput;
import com.codecool.marsexploration.io.FolderFileCreator;
import com.codecool.marsexploration.io.ImageGenerator;
import com.codecool.marsexploration.io.ReadFolder;
import com.codecool.marsexploration.io.LogWriter;
import com.codecool.marsexploration.logic.ExplorationSimulator;
import com.codecool.marsexploration.logic.Place;
import com.codecool.marsexploration.ui.Display;
import com.codecool.marsexploration.ui.Input;
import com.codecool.marsexploration.utility.ContextGenerator;
import com.codecool.marsexploration.utility.UserInputGenerator;

import java.io.File;
import java.util.Map;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        Display display = new Display();
        Input input = new Input(display);
        Random random = new Random();
        Place place = new Place(random);
        ReadFolder readFolder = new ReadFolder();
        Map<Integer, String> getPlanetMapName = readFolder.fromPath("src/main/resources", ".map", display);
        String planetMapPath = "/" + getPlanetMapName.get(random.nextInt(getPlanetMapName.size()));
        UserInputGenerator userInputGenerator = new UserInputGenerator(display, input);
        UserInput userInput = userInputGenerator.getInputs();
        SimulationInput simulationInput = new SimulationInput(
                planetMapPath,
                userInput.timeout(),
                "src/main/resources/exploration-1.log",
                new SuccessCondition(userInput.neededMinerals(), userInput.neededWater(), 50, 50));
        ContextGenerator contextGenerator = new ContextGenerator(display, random, userInput);
        Context context = contextGenerator.generate(simulationInput);
        place.randomAlien(context, userInput.amountAliens());
        display.doubleArrayMap(context.getMap(), "Read Map With Alien");
        FolderFileCreator folderFileCreator = new FolderFileCreator(display, readFolder);
        File newFile = folderFileCreator.getDestination();
        LogWriter writer = new LogWriter(newFile);
        ImageGenerator imageGenerator = new ImageGenerator(context);
        ExplorationSimulator simulator = new ExplorationSimulator(display, writer, context, imageGenerator);
        simulator.simulate();
    }
}