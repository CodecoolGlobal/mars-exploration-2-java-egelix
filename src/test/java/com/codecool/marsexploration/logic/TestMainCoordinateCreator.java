package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.Coordinate;

import java.util.Set;

public class TestMainCoordinateCreator {

    public static void main(String[] args) {
        CoordinateCreator coordinateCreator = new CoordinateCreator();
        Coordinate coordinateTest = new Coordinate(0, 0);
        Set<Coordinate> test = coordinateCreator.aroundRover(coordinateTest, 20, 2);
        System.out.println(test.size());
        for (Coordinate c : test) {
            System.out.println(c);
        }
    }
}