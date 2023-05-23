package com.codecool.marsexploration;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.logic.CoordinateCreator;

import java.util.Set;

public class TestMain {

    public static void main(String[] args) {
        CoordinateCreator coordinateCreator = new CoordinateCreator();
        Coordinate coordinateTest = new Coordinate(10, 10);
        Set<Coordinate> test = coordinateCreator.aroundRover(coordinateTest, 20, 2);
        System.out.println(test.size());
        for (Coordinate c : test) {
            System.out.println(c);
        }
    }
}