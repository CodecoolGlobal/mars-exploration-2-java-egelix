package com.codecool.marsexploration.logic.movement;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Symbol;
import com.codecool.marsexploration.data.rover.Rover;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomMove implements Move {
    private Coordinate lastVisitedCoordinate;
    private Set<Coordinate> visitedCoordinates = new HashSet<>();

    @Override
    public void move(String[][] map, Coordinate landing, Set<Coordinate> scannedFields, Rover rover) {
        if (lastVisitedCoordinate == null) {
            visitedCoordinates.add(landing);
        }
        List<Coordinate> emptyFields = new ArrayList<>();
        for (Coordinate scannedField : scannedFields) {
            int y = scannedField.y();
            int x = scannedField.x();

            if (map[y][x].equals(Symbol.EMPTY.getSymbol()) && Math.abs(y - rover.getPosition().y()) <= 1 && Math.abs(x - rover.getPosition().x()) <= 1) {
                emptyFields.add(scannedField);
            }
        }
        emptyFields.removeAll(visitedCoordinates);
        if (emptyFields.size() > 0) {
            Coordinate randomEmptyField = emptyFields.get((int) (Math.random() * emptyFields.size()));
            rover.setPosition(randomEmptyField);
            lastVisitedCoordinate = randomEmptyField;
            visitedCoordinates.add(randomEmptyField);
        } else {
            rover.setPosition(lastVisitedCoordinate);
        }
    }
}