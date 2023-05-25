package com.codecool.marsexploration.utility;

import com.codecool.marsexploration.data.UserInput;
import com.codecool.marsexploration.ui.Display;
import com.codecool.marsexploration.ui.Input;

public class UserInputGenerator {
    private final Display display;
    private final Input input;

    public UserInputGenerator(Display display, Input input) {
        this.display = display;
        this.input = input;
    }

    public UserInput getInputs() {
        display.printTitle("Welcome to planet explorer");
        display.printSubtitle("Create your Conditions");
        int timeout = getInput(100, "Please enter the amount of possible Rover Steps (Timeout).\n" +
                "Enter a number between 0 and 100!");
        int neededMinerals = getInput(10, "Please enter the amount of needed minerals(*) to conolarize.\n" +
                "Enter a number between 0 and 10!");
        int neededWater = getInput(10, "Please enter the amount of needed water(~) to conolarize.\n" +
                "Enter a number between 0 and 10!");
        int amountAliens = getInput(100, "Please enter the amount of aliens(A) on this planet.\n" +
                "Enter a number between 0 and 100!");
        int roverSight = getInput(10, "Please enter the rover sight.\n" +
                "Enter a number between 0 and 10!");
        return new UserInput(timeout, neededMinerals, neededWater, amountAliens, roverSight);
    }

    private int getInput(int conditionTo, String conditionMessage) {
        int timeout = -1;
        while (timeout < 0 || timeout > conditionTo) {
            timeout = input.getNumericUserInput(conditionMessage);
        }
        return timeout;
    }
}