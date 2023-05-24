package com.codecool.marsexploration.io;

import com.codecool.marsexploration.data.Context;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Writer {

    public void writeLog(Context log) {
        try {
            doWrite(log);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void doWrite(Context context) throws IOException {
        String logStr = getLogStr(context);
        File file = getDestination();
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
        writer.write(logStr);
        writer.close();
    }

    public String getLogStr(Context context) {
        if (context.getOutcome().isEmpty()) {
            return "STEP " + context.getStepNumber() +
                    "; EVENT " + context.getRover().getMove().getName() +
                    "; UNIT rover-" + context.getRover().getId() +
                    ", POSITION " + context.getRover().getPosition().toString() + "\n";
                    /*
                    "; POSITION [" + context.getRover().getPosition().y() +
                    "," + context.getRover().getPosition().x() + "]\n";
                     */

        } else {
            return "STEP " + context.getStepNumber() +
                    "; EVENT outcome" +
                    "; OUTCOME " + context.getOutcome();
        }
    }

    private File getDestination() {
        String path = "src/main/resources/output/";
        String dateString = getDatePartOfFileName();
        String fileName = path + dateString + "/" + "LogFile_" + dateString + ".log";
        File file = new File(fileName);
        file.getParentFile().mkdirs();
        return file;
    }

    private String getDatePartOfFileName() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuMMdd");
        LocalDate localDate = LocalDate.now();
        dtf.format(localDate);
        return dtf.format(localDate);
    }
}