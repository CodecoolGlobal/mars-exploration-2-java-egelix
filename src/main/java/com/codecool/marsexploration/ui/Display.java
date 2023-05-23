package com.codecool.marsexploration.ui;

public class Display {
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_DEFAULT = "\u001B[0m";
    private final int displayLength = 80;

    public void printTitle(String title) {
        System.out.println();
        String fillWithSpace = " ".repeat((displayLength - title.length()) / 2);
        System.out.println("✧".repeat(displayLength));
        System.out.println(fillWithSpace + title.toUpperCase() + fillWithSpace);
        System.out.println("✧".repeat(displayLength));
    }

    public void printSubtitle(String subtitle) {
        String fillWithSpace = " ".repeat((displayLength - subtitle.length()) / 2);
        System.out.println(fillWithSpace + subtitle.toUpperCase() + fillWithSpace);
        System.out.println("✧".repeat(displayLength));
    }

    public void message(String message) {
        System.out.println(message);
    }

    public void printEndLines() {
        System.out.println("✧".repeat(displayLength));
    }

    public void errorMessage(String message) {
        System.out.println(ANSI_RED + message + ANSI_DEFAULT);
    }
}