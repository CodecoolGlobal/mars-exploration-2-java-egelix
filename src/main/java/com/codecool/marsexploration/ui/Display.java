package com.codecool.marsexploration.ui;

import java.util.Arrays;

public class Display {
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_BLUE_BOLD = "\u001B[1;34m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_GREEN_BOLD = "\u001B[1;32m";
    private static final String ANSI_DEFAULT = "\u001B[0m";
    private final int displayLength = 72;

    public void doubleArrayMap(String[][] map, String message) {
        printTitle(message);
        for (String[] yString : map) {
            System.out.println(Arrays.toString(yString));
        }
    }

    public void printTitle(String title) {
        System.out.println();
        String fillWithSpace = " ".repeat((displayLength - title.length()) / 2);
        System.out.println("✧".repeat(displayLength));
        System.out.println(fillWithSpace + ANSI_GREEN_BOLD + title.toUpperCase() + ANSI_DEFAULT + fillWithSpace);
        System.out.println("✧".repeat(displayLength));
    }

    public void printSubtitle(String subtitle) {
        String fillWithSpace = " ".repeat((displayLength - subtitle.length()) / 2);
        System.out.println(fillWithSpace + ANSI_GREEN + subtitle.toUpperCase() + ANSI_DEFAULT + fillWithSpace);
        System.out.println("✧".repeat(displayLength));
    }

    public void inputRequirement(String requirement) {
        System.out.println(ANSI_BLUE_BOLD + requirement + ANSI_DEFAULT);
    }

    public void inputMessage() {
        System.out.print(ANSI_BLUE + "Your input is: " + ANSI_DEFAULT);
    }

    public void message(String message) {
        System.out.println(message);
    }

    public void printLines() {
        System.out.println("-".repeat(displayLength));
    }

    public void printEndLines() {
        System.out.println("✧".repeat(displayLength));
    }

    public void errorMessage(String message) {
        System.out.println(ANSI_RED + message + ANSI_DEFAULT);
    }
}