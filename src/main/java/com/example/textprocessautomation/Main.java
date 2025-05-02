package com.example.textprocessautomation;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Process single file or batch folder? (single/batch): ");
        String mode = scanner.nextLine();

        if (mode.equalsIgnoreCase("batch")) {
            System.out.print("Enter folder path: ");
            String folderPath = scanner.nextLine();

            List<File> files = FileHandler.listTextFiles(folderPath);
            System.out.println("Found " + files.size() + " .txt files.");

            System.out.print("Enter regex (or leave empty to skip): ");
            String regex = scanner.nextLine();

            String replacement = "";
            if (!regex.isBlank()) {
                System.out.print("Enter replacement text: ");
                replacement = scanner.nextLine();
            }

            System.out.print("Analyze files? (yes/no): ");
            String analyze = scanner.nextLine();

            if (analyze.equalsIgnoreCase("yes")) {
                for(File file : files) {
                    System.out.println(file.getName() + ":");

                    String content = FileHandler.readFile(file.getPath());
                    TextAnalyzer.analyzeText(content);

                    System.out.println();
                }
            }

            System.out.print("Enter output folder path: ");
            String outputFolder = scanner.nextLine();
            new File(outputFolder).mkdirs();

            for (File file : files) {
                String content = FileHandler.readFile(file.getAbsolutePath());

                content = FileHandler.cleanText(content);

                if (!regex.isBlank()) {
                    String replacedContent = RegexProcessor.replaceMatches(content, regex, replacement);
                    String outPath = outputFolder + "/" + file.getName();
                    FileHandler.writeFile(outPath, replacedContent);
                }
                System.out.println("Processed: " + file.getName());
            }

        } else if (mode.equalsIgnoreCase("single")) {
            System.out.print("Analyze file? (yes/no): ");
            String analyze = scanner.nextLine();

            if (analyze.equalsIgnoreCase("yes")) {
                System.out.print("Enter file path: ");
                String path = scanner.nextLine();

                String content = FileHandler.readFile(path);
                TextAnalyzer.analyzeText(content);
                System.out.println();
                System.out.print("Enter regex (or leave empty to skip): ");
                String regex = scanner.nextLine();

                String replacement = "";
                if (!regex.isBlank()) {
                    System.out.print("Enter replacement text: ");
                    replacement = scanner.nextLine();

                    RegexProcessor.replaceMatches(content, regex, replacement);
                }

                System.out.print("Enter output folder path: ");
                String outputFolder = scanner.nextLine();
                new File(outputFolder).mkdirs();

                String outPath = outputFolder + "/" + new File(path).getName();
                FileHandler.writeFile(outPath, content);
                System.out.println("Processed: " + new File(path).getName());

                Map<String, Long> freqMap = TextAnalyzer.wordFrequency(content);

                try {
                    System.out.print("Show top N frequent words(yes/no)? ");
                    if (scanner.nextLine() == "yes") {
                        System.out.println("Enter top N: ");
                        int topN = Integer.parseInt(scanner.nextLine());
//                    int topN = 5;
                        try {
                            topN = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Showing top 5 words by default.");
                        }

                        List<Map.Entry<String, Long>> topWords = TextAnalyzer.topWords(freqMap, topN);
                        topWords.forEach(entry ->
                                System.out.println(entry.getKey() + ": " + entry.getValue())
                        );
                    }
                } catch (Exception e) {
                    System.out.println("There was an exception: " + e);
                }

            }
            try {
                System.out.print("Enter file path: ");
                String filePath = scanner.nextLine();

                String content = FileHandler.readFile(filePath);

                System.out.print("Enter regex pattern: ");
                String regex = scanner.nextLine();

                List<String> matches = RegexProcessor.findMatches(content, regex);

                if (!matches.isEmpty()) {
                    System.out.println("Matches found: " + matches.size());
//                    matches.forEach(System.out::println);

                    System.out.print("Do you want to replace matches? (yes/no): ");
                    String choice = scanner.nextLine();

                    if (choice.equalsIgnoreCase("yes")) {
                        System.out.print("Enter replacement text: ");
                        String replacement = scanner.nextLine();
                        String replaceContent = RegexProcessor.replaceMatches(content, regex, replacement);
                        FileHandler.writeFile(filePath, replaceContent);
                    }
                } else {
                    System.out.println("No match found for pattern: " + regex);
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        }

        scanner.close();
    }
}
