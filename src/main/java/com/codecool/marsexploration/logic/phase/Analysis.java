package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Symbol;
import com.codecool.marsexploration.data.rover.FoundResource;

import java.util.HashSet;
import java.util.Set;

public class Analysis implements Phase {

    @Override
    public void perform(Context context) {
        Set<Coordinate> scannedCoordinates = context.getScannedFields();
        String[][] map = context.getMap();
        getPossibleNextCoordinates(context, scannedCoordinates, map);
        getFoundResources(context, scannedCoordinates, map);
    }

    private void getFoundResources(Context context, Set<Coordinate> scannedCoordinates, String[][] map) {
        Set<FoundResource> foundResources = new HashSet<>();
        for (Coordinate coordinate : scannedCoordinates) {
            if (map[coordinate.y()][coordinate.x()].equals(Symbol.MINERAL.getSymbol()) ||
                    map[coordinate.y()][coordinate.x()].equals(Symbol.WATER.getSymbol())) {
                FoundResource foundResource = new FoundResource(map[coordinate.y()][coordinate.x()], coordinate);
                foundResources.add(foundResource);
            }
        }
        context.setFoundResources(foundResources);
    }

    private void getPossibleNextCoordinates(Context context, Set<Coordinate> scannedCoordinates, String[][] map) {
        Set<Coordinate> possibleNextMove = new HashSet<>();
        for (Coordinate coordinate : scannedCoordinates) {
            if (map[coordinate.y()][coordinate.x()].equals(Symbol.EMPTY.getSymbol())) {
                possibleNextMove.add(coordinate);
            }
        }
        context.setPossibleNextMove(possibleNextMove);
    }
}