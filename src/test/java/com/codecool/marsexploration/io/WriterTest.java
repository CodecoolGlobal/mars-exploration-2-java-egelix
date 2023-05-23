package com.codecool.marsexploration.io;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.LogFile;
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
                Arguments.of(new LogFile(3, "stepping", 4, new Coordinate(3,3), "unknown"),
                        "STEP 3; EVENT stepping; UNIT rover-4; POSITION [3,3]")
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