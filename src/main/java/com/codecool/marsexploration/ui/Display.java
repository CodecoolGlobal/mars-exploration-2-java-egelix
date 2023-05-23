package com.codecool.marsexploration.ui;

public class Display {
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_DEFAULT = "\u001B[0m";

    public void message(String message) {
        System.out.println(message);
    }

    public void printEndLines() {
        int displayLength = 80;
        System.out.println("✧".repeat(displayLength));
    }

    public void errorMessage(String message) {
        System.out.println(ANSI_RED + message + ANSI_DEFAULT);
    }
}