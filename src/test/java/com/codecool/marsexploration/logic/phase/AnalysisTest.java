package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Outcome;
import com.codecool.marsexploration.data.SuccessCondition;
import com.codecool.marsexploration.logic.analyzer.Analyzer;
import com.codecool.marsexploration.logic.analyzer.LackOfRessourcesAnalyzer;
import com.codecool.marsexploration.logic.analyzer.SuccessAnalyzer;
import com.codecool.marsexploration.logic.analyzer.TimeoutAnalyzer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class AnalysisTest {
    public static Stream<Arguments> dataForAnalyzeTest() {
        return Stream.of(
                Arguments.of(10, 4, 4, Outcome.TIMEOUT),
                Arguments.of(12, 3, 3, Outcome.TIMEOUT),
                Arguments.of(8, 7, 7, Outcome.COLONIZABLE),
                Arguments.of(10, 7, 7, Outcome.COLONIZABLE),
                Arguments.of(8, 3, 3, null)
        );
    }
    @ParameterizedTest
    @MethodSource("dataForAnalyzeTest")
    void performTest(int stepsToSet, int waterToSet, int mineralToSet, Outcome expected) {
        Context context = new Context(10, null, null, null, Optional.empty(), new SuccessCondition(5,5));
        context.setStepNumber(stepsToSet);
        for(int i = 0; i < waterToSet; i++) {
            context.getScannedCoordinates().put(new Coordinate(i,i), "~");
        }
        for(int i = waterToSet; i < waterToSet + mineralToSet; i++) {
            context.getScannedCoordinates().put(new Coordinate(i,i), "*");
        }
        List<Analyzer> analyzers = List.of(
                new SuccessAnalyzer(),
                new TimeoutAnalyzer(),
                new LackOfRessourcesAnalyzer());
        Analysis analysis = new Analysis(analyzers);
        analysis.perform(context);
        Outcome result = context.getOutcome().isPresent() ? context.getOutcome().get() : null;
        assertEquals(expected, result);
    }
}