package com.example.textprocessautomation;

import java.util.List;
import java.util.regex.*;
import java.util.ArrayList;

public class RegexProcessor {

    // Find matching pattern with regex
    public static List<String> findMatches(String text, String regex) {
        List<String> matches = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            matches.add(matcher.group());
        }
        return matches;
    }


    // Replace regex pattern in text
    public static String replaceMatches(String text, String regex, String replacement) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll(replacement);
    }
}

