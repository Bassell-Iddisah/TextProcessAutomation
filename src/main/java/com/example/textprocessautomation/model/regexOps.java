package com.example.textprocessautomation.model;

import java.util.regex.*;

public class regexOps {

    String find(String data, String patternString) {
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(data);

        return matcher.group().toString();
    }

    void extract(String data, String patternString) {
    }
}
