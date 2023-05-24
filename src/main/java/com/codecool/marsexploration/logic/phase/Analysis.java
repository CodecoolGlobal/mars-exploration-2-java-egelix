package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Outcome;
import com.codecool.marsexploration.logic.analyzer.Analyzer;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class Analysis implements Phase {

    private final List<Analyzer> analyzers;

    public Analysis(List<Analyzer> analyzers) {
        this.analyzers = analyzers;
    }

    @Override
    public void perform(Context context) {
        analyzers.stream()
                .map(analyzer -> analyzer.analyze(context))
                .filter(optional -> optional.isPresent())
                .findFirst()
                .stream().peek(optional -> context.setOutcome(optional));
    }
}