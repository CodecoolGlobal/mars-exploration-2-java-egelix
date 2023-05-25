package com.codecool.marsexploration.utility;

import com.codecool.marsexploration.data.Outcome;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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
    }
}