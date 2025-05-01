package com.example.textprocessautomation;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in); // Initialize new scanner object
//
//        System.out.print("Process single file or batch folder? (single/batch): ");
//        String mode = scanner.nextLine();
//
//        if (mode.equalsIgnoreCase("batch")) {
//            System.out.print("Enter folder path: ");
//            String folderPath = scanner.nextLine();
//
//            List<File> files = FileHandler.listTextFiles(folderPath);
//            System.out.println("Found " + files.size() + " .txt files.");
//
//            System.out.print("Enter regex (or leave empty to skip): ");
//            String regex = scanner.nextLine();
//
//            String replacement = ""; // Make use of regex if provided
//            if (!regex.isBlank()) {
//                System.out.print("Enter replacement text: ");
//                replacement = scanner.nextLine();
//            }
//
//            System.out.print("Enter output folder path: ");
//            String outputFolder = scanner.nextLine();
//            new File(outputFolder).mkdirs(); // Ensure folder exists
//
//            // Clean each file in path
//            for (File file : files) {
//                String content = FileHandler.readFile(file.getAbsolutePath());
//                content = FileHandler.cleanText(content);
//                if (!regex.isBlank()) {
//                    content = RegexProcessor.replaceMatches(content, regex, replacement);
//                }
//                String outPath = outputFolder + "/" + file.getName();
//                FileHandler.writeFile(outPath, content);
//                System.out.println("Processed: " + file.getName());
//            }
//        } else if (mode.equalsIgnoreCase("single")) { // Process a file on its own
//            System.out.print("Analyze file? (yes/no): ");
//            String analyze = scanner.nextLine();
//
//            if (analyze.equalsIgnoreCase("yes")) {
//                System.out.print("Enter file path: ");
//                String path = scanner.nextLine();
//
//                String content = FileHandler.readFile(path);
//
//                TextAnalyzer.analyzeText(content);
//
//                Map<String, Long> freqMap = TextAnalyzer.wordFrequency(content);
//
//                System.out.print("Show top N frequent words: ");
//                int topN = Integer.parseInt(scanner.nextLine());
//
//                List<Map.Entry<String, Long>> topWords = TextAnalyzer.topWords(freqMap, topN);
//                topWords.forEach(entry ->
//                        System.out.println(entry.getKey() + ": " + entry.getValue())
//                );
//            } else {
//                try {
//                    System.out.print("Enter file path: "); // Accept all necessary input.
//                    String filePath = scanner.nextLine();
//
//                    String content = FileHandler.readFile(filePath);
//
//                    System.out.print("Enter regex pattern: ");
//                    String regex = scanner.nextLine();
//
//                    String matches = RegexProcessor.findMatches(content, regex);
//
//                    if (matches.isEmpty()) {
//                        System.out.println("No match found for pattern: " + regex);
//                    }
//
//                    System.out.print("Do you want to replace matches? (yes/no): ");
//                    String choice = scanner.nextLine();
//
//                    if (choice.equalsIgnoreCase("yes")) {
//                        System.out.print("Enter replacement text: ");
//                        String replacement = scanner.nextLine();
//
//                        String replacedContent = RegexProcessor.replaceMatches(content, regex, replacement);
//
//                        System.out.print("Enter output file path: ");
//                        String outputPath = scanner.nextLine();
//
//                        FileHandler.writeFile(outputPath, replacedContent);
//                        System.out.println("New content saved to " + outputPath);
//                    }
//
//                } catch (Exception e) {
//                    System.out.println("Error: " + e.getMessage());
//                }
//            }
//        }

        try {
            String path = "jkal";
            String content = FileHandler.readFile(path);
            // Processing logic...
        } catch (Exception e) {
            Logger.logError("Unexpected error in main flow.", e);
            System.out.println("Something went wrong. Check the log file.");
        }
    }
}
