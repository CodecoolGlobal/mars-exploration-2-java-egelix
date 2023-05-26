package com.codecool.marsexploration.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class Reader {

    public String[][] mapReader(String mapPath) throws IOException {
        String[][] mapArr;
        InputStream inputStream = getClass().getResourceAsStream(mapPath);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(Objects.requireNonNull(inputStream)))) {
            String line = br.readLine();
            mapArr = new String[line.length()][line.length()];
            updateArrValuesFromLine(mapArr, 0, line);
            for (int row = 1; row < line.length(); row++) {
                line = br.readLine();
                updateArrValuesFromLine(mapArr, row, line);
            }
            return mapArr;
        }
//        return Files.lines(Paths.get(mapPath))
//                .map(line-> line.split(""))
//                .toArray(String[][]::new);
    }

    private void updateArrValuesFromLine(String[][] mapArr, int row, String line) {
        char[] charArr = line.toCharArray();
        for (int col = 0; col < charArr.length; col++) {
            mapArr[row][col] = String.valueOf(charArr[col]);
        }
    }
}