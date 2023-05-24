package com.codecool.marsexploration.logic.analyzer;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Outcome;
import com.codecool.marsexploration.data.Symbol;

import java.util.List;
import java.util.Optional;

public class AlienAnalyzer implements Analyzer {
    @Override
    public Optional<Outcome> analyze(Context context) {
        List<String> scannedAliens = context.getScannedCoordinates().values().stream()
                .filter(symbol -> symbol.equals(Symbol.ALIEN.getSymbol())).toList();
        if (scannedAliens.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(Outcome.NOT_COLONIZABLE_ALIENS);
        }
    }
}