package com.codecool.marsexploration.logic.analyzer;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Outcome;
import com.codecool.marsexploration.data.Symbol;

import java.util.Map;
import java.util.Optional;

public class SuccessAnalyzer implements Analyzer{
    @Override
    public Optional<Outcome> analyze(Context context) {
        Map<Coordinate, String> scannedCoordinates = context.getScannedCoordinates();
        scannedCoordinates.entrySet().stream()
                .peek(entry -> updateFoundResoures(entry));
        return Optional.empty();
    }

    private void updateFoundResoures(Map.Entry<Coordinate, String> entry) {
            if (entry.getValue() == Symbol.MINERAL.getSymbol()) {
                //foundMin += 1;
            } else if (entry.getValue() == Symbol.WATER.getSymbol()) {
                //foundWater += 1;
        }
    }
}