package com.codecool.marsexploration.data;

public record LogFile(int step, String event, int roverId, int[][] position, String outcome,
                      FoundResources foundResources) {
}