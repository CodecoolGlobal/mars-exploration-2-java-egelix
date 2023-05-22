package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Symbol;

import java.util.HashSet;
import java.util.Set;

public class Analysis implements Phase {

    @Override
    public void perform(Context context) {
        Set<Coordinate> scannedCoordinates = context.getScannedFields();
        String[][] map = context.getMap();
        getPossibleNextCoordinates(context, scannedCoordinates, map);
        //ToDo make add FoundResources to Set and keep old set!
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