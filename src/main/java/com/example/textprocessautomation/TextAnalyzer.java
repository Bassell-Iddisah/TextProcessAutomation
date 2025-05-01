package com.example.textprocessautomation;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TextAnalyzer {
    // Return a Map of words and their appear frequency
    public static Map<String, Long> wordFrequency(String text) {
        return Arrays.stream(text.toLowerCase().split("\\W+"))
                .filter(word -> !word.isBlank())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    // Return a List of top N frequency words
    public static List<Map.Entry<String, Long>> topWords(Map<String, Long> freqMap, int topN) {
        return freqMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topN)
                .toList();
    }

    //
    public static void summarizeText(String text) {
        long wordCount = Arrays.stream(text.split("\\W+"))
                .filter(word -> !word.isBlank()).count(); // Total number of words in text

        long lineCount = Arrays.stream(text.split("\\R")).count(); // Total number of lines in text

        System.out.println("Total Words: " + wordCount);
        System.out.println("Total Lines: " + lineCount);
    }


}
