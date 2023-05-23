package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;

import java.util.Set;

public class Movement implements Phase{
    //get coordinates of landing, get surrounding fields

    //TODO: random movement
    //and choose randomly, count resources and save coordinates

    //TODO: return movement
    //return after an outcome is met

    //TODO: sequential movement
    //move from top to bottom row after row

    //TODO: smartMovement
    //and filter for
    //resources(, save coordinates) and count for condition (water & minerals)

    @Override
    public void perform(Context context) {
        Coordinate landing = context.getLanding();
        Set<Coordinate> scannedFields = context.getScannedFields();

        //TODO: implement logic for switching between movement approach/return movement

        //eventually return new map with resources
    }

    private void randomMovement(Set<Coordinate> scannedFields) {
        for (Coordinate coordinate : scannedFields) {
            System.out.println(coordinate);
        }
    }

    private void returnHome () {

    }

    private void moveSequentially () {

    }

    private void moveSmart () {

    }
}
