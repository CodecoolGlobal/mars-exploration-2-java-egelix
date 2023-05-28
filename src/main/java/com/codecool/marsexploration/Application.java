package com.codecool.marsexploration;

import com.codecool.marsexploration.data.Context;
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
import com.codecool.marsexploration.utility.ScannedMapGenerator;
import com.codecool.marsexploration.utility.UserInputGenerator;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.apache.commons.lang3.StringUtils.containsIgnoreCase;

public class Application {
    public static void main(String[] args) {
        int displayLength = 72;
        Display display = new Display(displayLength);
        Input input = new Input(display);
        Random random = new Random();
        ReadFolder readFolder = new ReadFolder();
        Reader reader = new Reader();
        String[][] map = getRandomMapFromFolder(display, random, readFolder, reader);
        Place place = new Place(random);
        /*
        SymbolGenerator symbolGenerator = new SymbolGenerator();
        Set<Symbol> symbolSet = symbolGenerator.createSymbolSet();
         */
        CoordinateCreator coordinateCreator = new CoordinateCreator();
        List<Analyzer> analyzers = List.of(
                new AlienAnalyzer(),
                new SuccessAnalyzer(),
                new LackOfRessourcesAnalyzer(),
                new TimeoutAnalyzer()
        );

        UserInputGenerator userInputGenerator = new UserInputGenerator(display, input);
        ImageWriter imageWriter = new ImageWriter();
        int thresholdRatio = 50;
        String newConditions = "yes";
        while (!containsIgnoreCase("n", newConditions)) {
            UserInput userInput = userInputGenerator.getInputs();
            String startNewExploration = "yes";
            while (!containsIgnoreCase("n", startNewExploration)) {ContextGenerator contextGenerator = new ContextGenerator(display, random, userInput, map);
                Context context = contextGenerator.generate(thresholdRatio);
                place.randomAlien(context, userInput.amountAliens());
                ScannedMapGenerator scannedMapGenerator = new ScannedMapGenerator(context);
                ImageGenerator imageGenerator = new ImageGenerator(scannedMapGenerator, imageWriter);
                display.doubleArrayMap(context.getMap(), "Read Map With Alien");
                FolderFileCreator folderFileCreator = new FolderFileCreator(display, readFolder);
                File newFile = folderFileCreator.getDestination("src/main/resources/logOutput/");
                LogWriter writer = new LogWriter(newFile);
                List<Phase> phases = List.of(
                        new Scan(coordinateCreator),
                        new Analysis(analyzers),
                        new Movement(),
                        new Log(display, writer),
                        new StepIncrement()
                );
                ExplorationSimulator simulator = new ExplorationSimulator(context, phases, imageGenerator);
                simulator.simulate();
                startNewExploration = input.getUserInput("Would you start a new Exploration with the same conditions?\n" +
                        "Please enter the command \"yes\"/\"y\" or \"no\"/\"n\".");
            }
            newConditions = input.getUserInput("Would you change the conditions?\n" +
                    "Please enter the command \"yes\"/\"y\" or \"no\"/\"n\".");
        }
    }

    private static String[][] getRandomMapFromFolder(Display display, Random random, ReadFolder readFolder, Reader reader) {
        Map<Integer, String> getPlanetMapName = readFolder.fromPath("src/main/resources", ".map", display);
        String planetMapPath = "/" + getPlanetMapName.get(random.nextInt(getPlanetMapName.size()));
        String[][] map;
        try {
            map = reader.mapReader(planetMapPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return map;
    }
}