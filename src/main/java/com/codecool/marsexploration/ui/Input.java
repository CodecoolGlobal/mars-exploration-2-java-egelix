package com.codecool.marsexploration.ui;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Input {
    private final Display display;

    public Input(Display display) {
        this.display = display;
    }

    public Integer getNumericUserInput(String requirement) {
        Integer result = null;
        while (result == null) {
            display.inputRequirement(requirement);
            display.inputMessage();
            Scanner scanner = new Scanner(System.in);
            try {
                result = scanner.nextInt();
            } catch (NoSuchElementException e) {
                display.errorMessage("Invalid input!");
            }
        }
        display.printLines();
        return result;
    }

    public String getUserInput(String message) {
        display.inputRequirement(message);
        display.inputMessage();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        display.printLines();
        return input;
    }
}