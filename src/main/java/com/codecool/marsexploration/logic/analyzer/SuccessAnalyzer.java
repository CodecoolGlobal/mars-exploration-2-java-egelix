package com.codecool.marsexploration.logic.analyzer;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Outcome;

import java.util.Optional;

public class SuccessAnalyzer implements Analyzer{
    @Override
    public Optional<Outcome> analyze(Context context) {
        return context.getStepNumber() == context.getTimeout() ? Optional.of(Outcome.TIMEOUT) : Optional.empty();
    }
}
