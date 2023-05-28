package com.codecool.marsexploration.logic.analyzer;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Outcome;
import com.codecool.marsexploration.data.SuccessCondition;
import com.codecool.marsexploration.data.symbol.Symbols;

import java.util.Optional;

public class LackOfRessourcesAnalyzer implements Analyzer {
    @Override
    public Optional<Outcome> analyze(Context context) {
        if (stepsOverConditionThreshold(context) &&
                resourcesUnderConditionThreshold(context)) {
            return Optional.of(Outcome.NOT_COLONIZABLE_RESOURCES);
        }
        return Optional.empty();
    }

    private boolean resourcesUnderConditionThreshold(Context context) {
        int amountFoundResources = getAmountFoundResources(context);
        SuccessCondition condition = context.getSuccessCondition();
        return amountFoundResources < ((double) (condition.amountWater() +
                condition.amountMinerals()) / 100 * condition.resourceThresholdRatio());
    }

    private boolean stepsOverConditionThreshold(Context context) {
        SuccessCondition condition = context.getSuccessCondition();
        return context.getStepNumber() >= (double) context.getTimeout() / 100 * condition.stepThresholdRatio();
    }

    private static int getAmountFoundResources(Context context) {
        return (int) context.getScannedCoordinates().entrySet().stream()
                .filter(entry ->
                        entry.getValue().equals(Symbols.WATER.getSymbol()) ||
                                entry.getValue().equals(Symbols.MINERAL.getSymbol()))
                .count();
    }
}