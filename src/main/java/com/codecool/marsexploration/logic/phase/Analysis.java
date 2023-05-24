package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.logic.analyzer.Analyzer;

import java.util.List;

public class Analysis implements Phase {

    private final List<Analyzer> analyzers;

    public Analysis(List<Analyzer> analyzers) {
        this.analyzers = analyzers;
    }

    @Override
    public void perform(Context context) {
        Optional<Optional<Outcome>> optional = analyzers.stream()
                .map(analyzer -> analyzer.analyze(context))
                .filter(opt -> opt.isPresent())
                .findFirst();
        if (optional.isPresent()) {
            context.setOutcome(optional.get());
        }
    }
}
