package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.logic.analyzer.Analyzer;

import java.util.List;

public class Analysis implements Phase {
    int foundWater = 0;
    int foundMinerals = 0;
    List<Analyzer> analyzers;

    public Analysis(List<Analyzer> analyzers) {
        this.analyzers = analyzers;
    }

    @Override
    public void perform(Context context) {
        updateFoundRessourcesAmount(context.getLogFile());
        for (Analyzer analyzer : analyzers) {
            analyzer.analyze(context);
        }
    }

    private void updateFoundRessourcesAmount(List<LogFile> logFile) {
    }
}