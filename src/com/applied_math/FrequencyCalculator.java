package com.applied_math;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FrequencyCalculator {

    public static Map<Character, Integer> calculateFrequency(String fileName) throws FileNotFoundException, IOException {
        Map<Character, Integer> frequency = new HashMap<>();
        Pattern p = Pattern.compile("[a-z1-9 \r]");
        FileReader reader = new FileReader(fileName);
        int c;
        while ((c = reader.read()) != -1) {
            Character ch = Character.toLowerCase((char) c);
            if (ch == '\n') continue;
            if (!p.matcher(ch.toString()).matches()) {
                ch = '.';
            }
            if (frequency.containsKey(ch)) {
                frequency.put(ch, frequency.get(ch) + 1);
            } else
                frequency.put(ch, 1);
        }
        return frequency;
    }

    public static List<Map.Entry<Character, Double>> calculateProbability(Map<Character, Integer> frequency) {
        int total = frequency.values().stream().mapToInt(Integer::intValue).sum();
        List<Map.Entry<Character, Double>> probability = frequency.entrySet()
                .stream()
                .map(entry -> new AbstractMap.SimpleEntry<>(entry.getKey(), (double) entry.getValue() / total))
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());
        return probability;
    }

    public static List<Map.Entry<Character, Integer>> sortFrequencies(Map<Character, Integer> frequency) {
        List<Map.Entry<Character, Integer>> sortedFrequency = frequency.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());
        return sortedFrequency;
    }

}
