package com.codecool.marsexploration.logic.analyzer;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Outcome;
import com.codecool.marsexploration.data.Symbol;

import java.util.Map;
import java.util.Optional;

public class SuccessAnalyzer implements Analyzer{
    private int foundMin;
    private int foundWater;

    private int successMin;
    private int successWater;
    Context context;

    public SuccessAnalyzer(Context context) {
        this.foundMin = 0;
        this.foundWater = 0;
        this.context = context;
        this.successMin = context.getSuccessCondition().amountMinerals();
        this.successWater = context.getSuccessCondition().amountWater();
    }

    @Override
    public Optional<Outcome> analyze() {

        Map<Coordinate, String> scannedCoordinates = context.getScannedCoordinates();
        scannedCoordinates.entrySet().stream()
                .peek(entry -> updateFoundResoures(entry));
        return Optional.empty();
    }

    private void updateFoundResoures(Map.Entry<Coordinate, String> entry) {
            if (entry.getValue() == Symbol.MINERAL.getSymbol()) {
                foundMin += 1;
            } else if (entry.getValue() == Symbol.WATER.getSymbol()) {
                foundWater += 1;
        }
    }
}