package com.codecool.marsexploration.logic.analyzer;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Outcome;

import java.util.Optional;

public class SuccessAnalyzer implements Analyzer{
    @Override
    public Optional<Outcome> analyze(Context context) {
        //ToDo Dyre Notiz: Es könnte sein das im context das Set mit den FoundResources immer wieder leer ist.
        //ToDo am besten gleich das Set hier immer wieder dazu adden. Bzw. vlt weist du wie ich immer das Set erweitern kann.
        return context.getStepNumber() == context.getTimeout() ? Optional.of(Outcome.TIMEOUT) : Optional.empty();
    }
}
