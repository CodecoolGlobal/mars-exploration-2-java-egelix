package com.codecool.marsexploration.io;

import com.codecool.marsexploration.data.Context;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogWriter {
    private final File newFile;

    public LogWriter(File newFile) {
        this.newFile = newFile;
    }

    public void writeLog(Context context) {
        try {
            doWrite(context);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void doWrite(Context context) throws IOException {
        String logEntry = buildLogEntry(context);
        BufferedWriter writer = new BufferedWriter(new FileWriter(newFile, true));
        writer.write(logEntry);
        writer.close();
    }

    public String buildLogEntry(Context context) {
        if (context.getOutcome().isEmpty()) {
            return "STEP " + context.getStepNumber() +
                    "; EVENT " + context.getRover().getMove().getName() +
                    "; UNIT rover-" + context.getRover().getId() +
                    "; POSITION [" + context.getRover().getPosition().y() +
                    "," + context.getRover().getPosition().x() + "]\n";
        } else {
            return "STEP " + context.getStepNumber() +
                    "; EVENT outcome" +
                    "outcome; OUTCOME " + context.getOutcome().get();

        }
    }
}