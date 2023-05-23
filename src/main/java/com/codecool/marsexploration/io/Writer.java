package com.codecool.marsexploration.io;

import com.codecool.marsexploration.data.LogFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Writer {
    //File path = new File(System.getProperty("src/main/resources/output/"));
    //File file = new File(path,"Logfile.log");
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
        String logStr = "STEP " + log.step() +
                "; EVENT " + log.event() +
                "; UNIT rover-" + log.roverId() +
                "; POSITION [" + log.position().y() +
                "," + log.position().x() + "]\n";
        return logStr;
    }

    private File getDestination() {
        String path = "src/main/resources/output/";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuMMdd");
        LocalDate localDate = LocalDate.now();
        dtf.format(localDate);
        String dateString = dtf.format(localDate);
        String fileName = path + dateString + "/" + "LogFile_" + dateString + ".log";
        File file = new File(fileName);
        file.getParentFile().mkdirs();
        return file;
    }
}