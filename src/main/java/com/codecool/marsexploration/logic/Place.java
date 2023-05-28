package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.symbol.Symbols;

import java.util.Random;

public class Place {
    private final Random random;

    public Place(Random random) {
        this.random = random;
    }

    public void randomAlien(Context context, int amount) {
        String[][] map = context.getMap();
        for (int i = 0; i < amount; i++) {
            Coordinate randomCoordinate = new Coordinate(random.nextInt(map.length), random.nextInt(map.length));
            String randomMapSymbol = map[randomCoordinate.y()][randomCoordinate.x()];
            boolean isFieldEmpty = randomMapSymbol.equals(Symbols.EMPTY.getSymbol());
            do {
                if (isFieldEmpty) {
                    map[randomCoordinate.y()][randomCoordinate.x()] = Symbols.ALIEN.getSymbol();
                } else {
                    randomCoordinate = new Coordinate(random.nextInt(map.length), random.nextInt(map.length));
                    randomMapSymbol = map[randomCoordinate.y()][randomCoordinate.x()];
                    isFieldEmpty = randomMapSymbol.equals(Symbols.EMPTY.getSymbol());
                }
            } while (!isFieldEmpty);
        }
    }
}