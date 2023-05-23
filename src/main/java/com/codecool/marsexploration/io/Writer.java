package com.codecool.marsexploration.io;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.LogFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Writer {

    public void writeLog(LogFile log) {
        try {
            doWrite(log);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void doWrite(LogFile log) throws IOException {
        String logStr = getLogStr(log);
        File file = getDestination();
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
        writer.write(logStr);
        writer.close();
    }

    public String getLogStr(LogFile log) {
        if (log.outcome() == null) {
            return "STEP " + log.step() +
                    "; EVENT " + log.event() +
                    "; UNIT rover-" + log.roverId() +
                    "; POSITION [" + log.position().y() +
                    "," + log.position().x() + "]\n";
        } else {
            return "STEP " + log.step() +
                    "; EVENT " + log.event() +
                    "; OUTCOME " + log.outcome();
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

    private static String getDatePartOfFileName() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuMMdd");
        LocalDate localDate = LocalDate.now();
        dtf.format(localDate);
        String dateString = dtf.format(localDate);
        return dateString;
    }

}
