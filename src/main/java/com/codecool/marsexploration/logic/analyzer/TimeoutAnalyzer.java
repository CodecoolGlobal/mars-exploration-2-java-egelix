package com.codecool.marsexploration.logic.analyzer;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Outcome;

import java.util.Optional;

public class TimeoutAnalyzer implements Analyzer {
    Context context;
    public TimeoutAnalyzer(Context context) {
        this.context = context;
    }
    @Override
    public Optional<Outcome> analyze() {
        return context.getStepNumber() >= context.getTimeout() ? Optional.of(Outcome.TIMEOUT) : Optional.empty();
    }
}