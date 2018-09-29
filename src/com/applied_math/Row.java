package com.applied_math;

public class Row {
    private char character;
    private double probability;
    private String code;
    private int lengthOfCode;

    public Row(char character, double probability, String code) {
        this.character = character;
        this.probability = probability;
        this.code = code;
        this.lengthOfCode = code.length();
    }

    public double getProbability() {
        return probability;
    }

    @Override
    public String toString() {
        return String.format("%s %.5f %s %d",character,probability,code,lengthOfCode);
    }
}

