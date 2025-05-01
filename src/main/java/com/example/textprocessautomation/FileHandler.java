package com.example.textprocessautomation;

import java.io.*;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;

public class FileHandler {

    // Read a file submitted by a user
    public static String readFile(String filePath) throws IOException {
        return Files.readString(Path.of(filePath));
    }

    // Write to the file
    public static void writeFile(String filePath, String content) throws IOException {
        Files.writeString(Path.of(filePath), content);
    }

    // Return list of .txt files in a path
    public static List<File> listTextFiles(String directoryPath) {
        File dir = new File(directoryPath);
        File[] files = dir.listFiles((d, name) -> name.endsWith(".txt"));
        return files != null ? Arrays.asList(files) : List.of();
    }

    // Clean up file content
    public static String cleanText(String content) {
        return content
                .replaceAll("[\\t ]+", " ")       // replace multiple spaces/tabs with one space
                .replaceAll("(?m)^\\s+", "")      // remove leading spaces per line
                .replaceAll("(?m)^\\s*$[\n\r]{1,}", "") // remove empty lines
                .trim();
    }


}

