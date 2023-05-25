package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.io.LogWriter;
import com.codecool.marsexploration.ui.Display;

public class Log implements Phase {
    private final Display display;
    private final LogWriter writer;

    public Log(Display display, LogWriter writer) {
        this.display = display;
        this.writer = writer;
    }

    @Override
    public void perform(Context context) {
        displayLog(context);
        writer.writeLog(context);
    }

    private void displayLog(Context context) {
        //String water = "";
        //String mineral = "";
        //ToDo Rework with new Map with Coordinate and Symbol

        /*
        for (FoundResource foundResource : foundResources) {
            if (Symbol.WATER.getSymbol().equals(foundResource.getSymbol())) {
                water = ";\nWATER AMOUNT " + foundResource.getCoordinate().size()
                        + " COORDINATE " + foundResource.getCoordinate();
            }
            if (Symbol.MINERAL.getSymbol().equals(foundResource.getSymbol())) {
                mineral = ";\nMINERAL AMOUNT " + foundResource.getCoordinate().size() + " COORDINATE " + foundResource.getCoordinate();
            }
        }
         */

        display.printTitle("Actual log " + context.getStepNumber());
        display.message("STEP " + context.getStepNumber() +
                "; EVENT " + (context.getOutcome().isEmpty() ?
                context.getRover().getMove().getName() +
                "; UNIT " + context.getRover().getId() +
                "; POSITION " + context.getRover().getPosition() :
                "outcome; OUTCOME " + context.getOutcome().get()));
        /*
        display.printTitle("Found resources");
        display.printSubtitle("water");
        display.message(water);
        display.printSubtitle("mineral");
        display.printSubtitle(mineral);
        display.printEndLines();
         */
    }
}