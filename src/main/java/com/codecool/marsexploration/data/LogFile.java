package com.codecool.marsexploration.data;

public record LogFile(int step, String event, int roverId, Coordinate position, String outcome) {
}