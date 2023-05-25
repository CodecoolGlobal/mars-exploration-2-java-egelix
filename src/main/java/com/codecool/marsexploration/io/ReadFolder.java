package com.codecool.marsexploration.io;

import com.codecool.marsexploration.ui.Display;

import java.io.File;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class ReadFolder {
    private final Display display;

    public ReadFolder(Display display) {
        this.display = display;
    }

    public Map<Integer, String> fromPath(String path, String searchFileExtension) {
        Map<Integer, String> files = new TreeMap<>();
        File folder = new File(path);
        int countValidFiles = 0;
        for (File file : Objects.requireNonNull(folder.listFiles())) {
            if (file.isFile() && file.getName().contains(searchFileExtension)) {
                files.put(countValidFiles, file.getName());
                countValidFiles++;
            }
        }
        if (files.size() == 0){
            display.errorMessage("Could not find a valid file");
        }
            return files;
    }
}