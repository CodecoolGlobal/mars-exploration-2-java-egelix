package com.codecool.marsexploration.io;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.LogFile;
import com.codecool.marsexploration.data.Outcome;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class WriterTest {
    Writer writer = new Writer();

    public static Stream<Arguments> argumentsForWriterTests() {
        return Stream.of(
                Arguments.of(new LogFile(
                                3,
                                "position",
                                4,
                                new Coordinate(3,3),
                                null),
                        "STEP 3; EVENT position; UNIT rover-4; POSITION [3,3]\n"),
                Arguments.of(new LogFile(
                                4,
                                "position",
                                4,
                                new Coordinate(4,3),
                                null),
                        "STEP 4; EVENT position; UNIT rover-4; POSITION [4,3]\n"),
                Arguments.of(new LogFile(
                                5,
                                "outcome",
                                4,
                                new Coordinate(5,3),
                                "TIMEOUT"),
                        "STEP 5; EVENT outcome; OUTCOME TIMEOUT\n")
        );
    }

    @ParameterizedTest
    @MethodSource("argumentsForWriterTests")
    void writeLogTest(LogFile log, String expected) {
        writer.writeLog(log);
        assertEquals(expected, expected);
    }

    @ParameterizedTest
    @MethodSource("argumentsForWriterTests")
    void getLogStringTest(LogFile log, String expected) {
        String result = writer.getLogStr(log);
        assertEquals(result, expected);
    }
}