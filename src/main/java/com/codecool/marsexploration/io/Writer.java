package com.codecool.marsexploration.io;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.LogFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

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
        String path = "src/main/resources/output/";
        String fileName = path + "Logfile.log";
        String logStr = getLogStr(log);
        File file = new File(fileName);
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
}
