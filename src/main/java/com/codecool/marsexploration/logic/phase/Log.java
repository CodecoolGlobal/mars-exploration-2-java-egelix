package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Symbol;
import com.codecool.marsexploration.data.rover.FoundResource;
import com.codecool.marsexploration.io.Writer;
import com.codecool.marsexploration.ui.Display;

import java.util.Set;

public class Log implements Phase {
    private final Display display;
    private final Writer writer;
    private final Set<FoundResource> foundResources;

    public Log(Display display, Writer writer, Set<FoundResource> foundResources) {
        this.display = display;
        this.writer = writer;
        this.foundResources = foundResources;
    }

    @Override
    public void perform(Context context) {
        displayLog(context);
        //ToDo add Writer with ActualLog or With List of all Logs.
    }

    private void displayLog(Context context) {
        String water = "";
        String mineral = "";
        for (FoundResource foundResource : foundResources) {
            if (Symbol.WATER.getSymbol().equals(foundResource.getSymbol())) {
                water = ";\nWATER AMOUNT " + foundResource.getAmount() + " COORDINATE " + foundResource.getCoordinate();
            }
            if (Symbol.MINERAL.getSymbol().equals(foundResource.getSymbol())) {
                mineral = ";\nMINERAL AMOUNT " + foundResource.getAmount() + " COORDINATE " + foundResource.getCoordinate();
            }
        }
        display.printTitle("Actual log");
        display.message("STEP " + context.getStepNumber() +
                "; EVENT " + (context.getOutcome().isEmpty() ? context.getRover().getRoutine() : context.getOutcome()) +
                "; UNIT " + context.getRover().getId() +
                "; POSITION " + context.getRover().getPosition());
        display.printSubtitle("Found resources");
        display.printSubtitle("water");
        display.message(water);
        display.printSubtitle("mineral");
        display.printSubtitle(mineral);
        display.printEndLines();
    }
}