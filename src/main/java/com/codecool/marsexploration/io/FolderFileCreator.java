package com.codecool.marsexploration.io;

import com.codecool.marsexploration.ui.Display;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class FolderFileCreator {
    private final Display display;
    private final ReadFolder readFolder;

    public FolderFileCreator(Display display, ReadFolder readFolder) {
        this.display = display;
        this.readFolder = readFolder;
    }

    public File getDestination() {
        String path = createFolder();
        return createFile(path);
    }

    private String createFolder() {
        //Best practice wäre statt / oder \ und String, Path mit ??? zu nutzen. Damit der Code für Windows und Linux/Mac geht.
        String path = "src/main/resources/output/" + createDatePartOfFileName();
        File folder = new File(path);
        folder.mkdir();
        return path;
    }

    private File createFile(String path) {
        Map<Integer, String> existingLogFiles = readFolder.fromPath(path, ".log", display);
        int currentFileNumber = existingLogFiles.size() + 1;
        String fileName = path + "/LogFile_" + currentFileNumber + ".log";
        return new File(fileName);
    }

    private String createDatePartOfFileName() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuMMdd");
        LocalDate localDate = LocalDate.now();
        dtf.format(localDate);
        return dtf.format(localDate);
    }
}