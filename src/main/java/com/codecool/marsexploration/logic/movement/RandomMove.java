package com.codecool.marsexploration.logic.movement;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Outcome;
import com.codecool.marsexploration.data.Symbol;
import com.codecool.marsexploration.ui.Display;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class RandomMove implements Move {
    private final Display display;
    private final Random random;

    public RandomMove(Display display, Random random) {
        this.display = display;
        this.random = random;
    }

    @Override
    public void move(Context context) {
        List<Coordinate> emptyFields = new ArrayList<>();
        validateNextEmptyCoordinates(context, emptyFields);
        moveToNextRandomEmptyCoordinate(context, emptyFields);
    }

    private void validateNextEmptyCoordinates(Context context, List<Coordinate> emptyFields) {
        for (Coordinate nextCoordinate : context.getNextMoveCoordinates()) {
            String mapSymbol = context.getMap()[nextCoordinate.y()][nextCoordinate.x()];
            if (mapSymbol.equals(Symbol.EMPTY.getSymbol())) {
                emptyFields.add(nextCoordinate);
            }
        }
        emptyFields.removeAll(context.getRover().getCoordinatesTracker());
    }

    private void moveToNextRandomEmptyCoordinate(Context context, List<Coordinate> emptyFields) {
        if (emptyFields.size() > 0) {
            Coordinate randomEmptyField = emptyFields.get(random.nextInt(emptyFields.size()));
            context.getRover().setPosition(randomEmptyField);
            context.getRover().addCoordinatesTracker(randomEmptyField);
        } else {
            display.errorMessage("No more empty next coordinate");
            context.setOutcome(Optional.of(Outcome.ROVER_CANT_MOVE));
        }
    }

    public String getName() {
        return "Random Movement";
    }
}