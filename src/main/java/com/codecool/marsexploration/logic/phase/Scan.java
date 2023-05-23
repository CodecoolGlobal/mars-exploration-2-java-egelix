package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.logic.CoordinateCreator;

import java.util.Set;

public class Scan implements Phase {
    private final CoordinateCreator coordinateCreator;

    public Scan(CoordinateCreator coordinateCreator) {
        this.coordinateCreator = coordinateCreator;
    }

    @Override
    public void perform(Context context) {
        Coordinate currentRoverPosition = context.getRover().getPosition();
        String[][] map = context.getMap();
        Set<Coordinate> scannedFields = coordinateCreator.aroundRover(currentRoverPosition, map.length);
        context.setScannedFields(scannedFields);
    }
}