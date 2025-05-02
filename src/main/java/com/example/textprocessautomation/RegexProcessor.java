package com.example.textprocessautomation;

import java.util.regex.*;

public class RegexProcessor {

    // Find matching pattern with regex
    public static String findMatches(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("Match: " + matcher.group() + " at index " + matcher.start());
            break;
        }
        return matcher.group();
    }

    // Replace regex pattern in text
    public static String replaceMatches(String text, String regex, String replacement) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll(replacement);
    }
}

