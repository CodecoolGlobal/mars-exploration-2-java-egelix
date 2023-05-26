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
        display.printTitle("Actual log " + context.getStepNumber());
        display.message("STEP " + context.getStepNumber() +
                "; EVENT " + (context.getOutcome().isEmpty() ?
                context.getRover().getMove().getName() +
                        "; UNIT " + context.getRover().getId() +
                        "; POSITION " + context.getRover().getPosition() :
                "outcome; OUTCOME " + context.getOutcome().get()));
    }
}