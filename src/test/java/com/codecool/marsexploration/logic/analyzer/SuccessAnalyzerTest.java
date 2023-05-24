package com.codecool.marsexploration.logic.analyzer;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Outcome;
import com.codecool.marsexploration.data.SuccessCondition;
import com.codecool.marsexploration.io.Reader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SuccessAnalyzerTest {
    public static Stream<Arguments> dataForAnalyzeTest() {
                return Stream.of(
                Arguments.of(5, 5, Outcome.COLONIZABLE),
                Arguments.of(7, 7, Outcome.COLONIZABLE),
                Arguments.of(3, 7, null),
                Arguments.of(3, 3, null)
        );
    }
    @ParameterizedTest
    @MethodSource("dataForAnalyzeTest")
    void analyzeTest(int waterToSet, int mineralToSet, Outcome expected) {
        Context context = new Context(10, null, null, null, Optional.empty(), new SuccessCondition(5,5, 50, 50));
        for(int i = 0; i < waterToSet; i++) {
            context.getScannedCoordinates().put(new Coordinate(i,i), "~");
        }
        for(int i = waterToSet; i < waterToSet + mineralToSet; i++) {
            context.getScannedCoordinates().put(new Coordinate(i,i), "*");
        }
        SuccessAnalyzer analyzer = new SuccessAnalyzer();
        Optional<Outcome> outcomeOpt = analyzer.analyze(context);
        Outcome result = outcomeOpt.isPresent() ? outcomeOpt.get() : null;
        assertEquals(expected, result);
    }
}