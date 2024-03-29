package com.codecool.marsexploration.logic.analyzer;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Outcome;
import com.codecool.marsexploration.data.symbol.Symbols;

import java.util.Map;
import java.util.Optional;

public class SuccessAnalyzer implements Analyzer {
    @Override
    public Optional<Outcome> analyze(Context context) {
        Map<Coordinate, String> scannedCoordinates = context.getScannedCoordinates();
        int foundMin = getAmountFoundResource(scannedCoordinates, Symbols.MINERAL);
        int foundWater = getAmountFoundResource(scannedCoordinates, Symbols.WATER);
        return enoughResourcesForSuccess(context, foundMin, foundWater) ?
                Optional.of(Outcome.COLONIZABLE) :
                Optional.empty();
    }

    private boolean enoughResourcesForSuccess(Context context, int foundMin, int foundWater) {
        return foundMin >= context.getSuccessCondition().amountMinerals() &&
                foundWater >= context.getSuccessCondition().amountWater();
    }

    private int getAmountFoundResource(Map<Coordinate, String> scannedCoordinates, Symbols symbols) {
        return (int) scannedCoordinates.entrySet().stream()
                .filter(entry -> entry.getValue().equals(symbols.getSymbol()))
                .count();
    }
}