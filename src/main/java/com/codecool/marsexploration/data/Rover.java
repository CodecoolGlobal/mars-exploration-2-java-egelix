package com.codecool.marsexploration.data;

import com.codecool.marsexploration.logic.routine.Routine;

import java.util.List;

public class Rover {
    private int id;
    private Coordinate position;
    private int sight;
    private Routine routine;
    private List<Coordinate> trackRecords;
}
