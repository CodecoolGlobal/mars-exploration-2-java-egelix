package com.codecool.marsexploration.logic.analyzer;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Outcome;
import com.codecool.marsexploration.data.SuccessCondition;
import com.codecool.marsexploration.data.rover.Rover;
import com.codecool.marsexploration.io.Reader;
import com.codecool.marsexploration.io.Writer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TimeoutAnalyzerTest {

    public static Stream<Arguments> dataForAnalyzeTest() throws IOException {
        Reader reader = new Reader();
        String[][] map = reader.mapReader("/exploration-1.map");
        //context1.getScannedCoordinates().put(new Coordinate(3,3), "~");
        //context1.getScannedCoordinates().put(new Coordinate(4,4), "~");
        //context1.getScannedCoordinates().put(new Coordinate(5,5), "~");
        //context1.getScannedCoordinates().put(new Coordinate(6,6), "*");
        return Stream.of(
                Arguments.of(10, Outcome.TIMEOUT),
                Arguments.of(12, Outcome.TIMEOUT),
                Arguments.of(8, null),
                Arguments.of(0, null)
        );
    }
    public static Context prepareContextSteps(Context context, int steps) {
        context.setStepNumber(steps);
        return context;
    }

    @ParameterizedTest
    @MethodSource("dataForAnalyzeTest")
    void analyzeTest(int stepsToSet, Outcome expected) {
        Context context = new Context(10, null, null, null, Optional.empty(), new SuccessCondition(5,5));
        context.setStepNumber(stepsToSet);
        TimeoutAnalyzer analyzer = new TimeoutAnalyzer();
        Optional<Outcome> outcomeOpt = analyzer.analyze(context);
        Outcome result = outcomeOpt.isPresent() ? outcomeOpt.get() : null;
        assertEquals(result, expected);
    }
}