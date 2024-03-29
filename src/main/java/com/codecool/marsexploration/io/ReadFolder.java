package com.codecool.marsexploration.io;

import com.codecool.marsexploration.ui.Display;

import java.io.File;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class ReadFolder {

    public Map<Integer, String> fromPath(String path, String searchFileExtension, Display display) {
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
            display.errorMessage("Could not find a valid file/folder" +
                    "New Folder was created");
        }
            return files;
    }
}