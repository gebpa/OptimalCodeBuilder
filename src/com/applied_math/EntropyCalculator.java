package com.applied_math;

import java.util.List;

public class EntropyCalculator {
    public static double getAverageLengthOfCode(List<Row> table){
        double entropy = table.stream()
                .mapToDouble(e->e.getProbability()*e.getLengthOfCode())
                .sum();
        return entropy;
    }
    public static double getEntropy(List<Row> table){
        double entropy = table.stream()
                .mapToDouble(e->-e.getProbability()*Math.log(e.getProbability()) / Math.log(2))
                .sum();
        return entropy;
    }
}
