package com.codecool.marsexploration.logic.analyzer;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Outcome;

import java.util.Optional;

public class LackOfRessourcesAnalyzer implements Analyzer{
    private int foundMin;
    private int foundWater;

    private int successMin;
    private int successWater;
    Context context;

    public LackOfRessourcesAnalyzer(Context context) {
        this.foundMin = 0;
        this.foundWater = 0;
        this.context = context;
        this.successMin = context.getSuccessCondition().amountMinerals();
        this.successWater = context.getSuccessCondition().amountWater();
    }
    @Override
    public Optional<Outcome> analyze() {
        return Optional.empty();
    }
}
