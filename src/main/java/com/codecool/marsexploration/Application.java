package com.codecool.marsexploration;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.SimulationInput;
import com.codecool.marsexploration.data.SuccessCondition;
import com.codecool.marsexploration.io.FolderFileCreator;
import com.codecool.marsexploration.io.ReadFolder;
import com.codecool.marsexploration.io.Writer;
import com.codecool.marsexploration.logic.ExplorationSimulator;
import com.codecool.marsexploration.logic.Place;
import com.codecool.marsexploration.ui.Display;
import com.codecool.marsexploration.utility.ContextGenerator;

import java.io.File;
import java.util.Map;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        Display display = new Display();
        Random random = new Random();
        Place place = new Place(random);
        ReadFolder readFolder = new ReadFolder();
        Map<Integer, String> getPlanetMapName = readFolder.fromPath("src/main/resources", ".map", display);
        String planetMapPath = "/" + getPlanetMapName.get(random.nextInt(getPlanetMapName.size()));
        SimulationInput input = new SimulationInput(
                planetMapPath,
                100,
                "src/main/resources/exploration-1.log",
                new SuccessCondition(2, 1, 50, 50));
        ContextGenerator contextGenerator = new ContextGenerator(display, random);
        Context context = contextGenerator.generate(input);
        place.randomAlien(context, 3);
        display.doubleArrayMap(context.getMap(), "Read Map With Alien");
        FolderFileCreator folderFileCreator = new FolderFileCreator(display, readFolder);
        File newFile = folderFileCreator.getDestination();
        Writer writer = new Writer(newFile);
        ExplorationSimulator simulator = new ExplorationSimulator(display, writer, context);
        simulator.simulate();
    }
}