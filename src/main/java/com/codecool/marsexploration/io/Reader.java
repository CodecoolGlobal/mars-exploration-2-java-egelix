package com.codecool.marsexploration.io;

import com.codecool.marsexploration.data.SimulationInput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    public String[][] mapGenerator(SimulationInput input) {
        String[][] mapArr;
        InputStream inputStream = getClass().getResourceAsStream(input.mapPath());
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line = br.readLine();
            mapArr = new String[line.length()][line.length()];
            for (int i = 0; i < line.length(); i++) {

            }
            while ((line = br.readLine()) != null && !line.isEmpty()) {
                List<String> fields = super.getFieldsFromLine(line);
                Long personId = Long.valueOf(fields.get(0));
                String id = fields.get(1);
                String name = fields.get(2);
                String character = fields.get(3);
                Role role = Role.valueOf(fields.get(4));
                credits.add(new Credit(personId, id, name, character, role));
            }
            return credits;
        } catch (IOException e) {
            System.out.println("File not found");
        }

    }


}
