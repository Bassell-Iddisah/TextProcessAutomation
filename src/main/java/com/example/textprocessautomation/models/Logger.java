package com.example.textprocessautomation;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

// Define logger for logging
public class Logger {
    private static final String LOG_FILE = "log.txt"; // Specify log file

    public static void log(String message) {
        write("INFO", message, null); // Login informational message
    }

    public static void logError(String message, Exception e) {
        write("ERROR", message, e); // Log error message
    }

    // Execute log writing
    private static void write(String level, String message, Exception e) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            writer.write(LocalDateTime.now() + " [" + level + "] " + message + "\n");
            if (e != null) {
                writer.write("    " + e.toString() + "\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
