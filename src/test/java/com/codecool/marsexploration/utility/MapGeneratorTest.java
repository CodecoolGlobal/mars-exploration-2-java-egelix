package com.codecool.marsexploration.utility;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Outcome;
import com.codecool.marsexploration.data.SuccessCondition;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MapGeneratorTest {
    public static Stream<Arguments> dataForGenerateMapOfScannedAreaTest(){
        return Stream.of(
                Arguments.of(10, Outcome.TIMEOUT),
                Arguments.of(12, Outcome.TIMEOUT),
                Arguments.of(8, null),
                Arguments.of(0, null)
        );
    }
    @ParameterizedTest
    @MethodSource("dataForGenerateMapOfScannedAreaTest")
    void generateMapOfScannedAreaTest() {
        String[][] testMap = new String[10][10];
        Context context = new Context(10, testMap, null, null, Optional.empty(), new SuccessCondition(5,5, 50, 50));

    }
}