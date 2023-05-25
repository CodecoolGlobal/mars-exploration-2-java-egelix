package com.codecool.marsexploration.utility;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;

import java.util.Map;

public class MapGenerator {
    Context context;

    public MapGenerator(Context context) {
        this.context = context;
    }

    public String[][] generateMapOfScannedArea() {
        String[][] map = generateEmptyMap();
        updateMapWithScannedCoordinates(map);
        return map;
    }

    private void updateMapWithScannedCoordinates(String[][] map) {
        for (Map.Entry<Coordinate, String> coord : context.getScannedCoordinates().entrySet()) {
            map[coord.getKey().y()][coord.getKey().x()] = coord.getValue();
        }
    }

    private String[][] generateEmptyMap() {
        int size = context.getMap().length;
        String[][] map = new String[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = "_";
            }
        }
        return map;
    }
}
