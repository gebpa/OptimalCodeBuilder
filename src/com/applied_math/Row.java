package com.applied_math;

public class Row {
    private char character;
    private double probability;
    private String code;
    private int lengthOfCode;

    public Row(char character, double probability) {
        this.character = character;
        this.code="";
        this.lengthOfCode=0;
        this.probability=probability;
    }

    public Row(char character, double probability, String code) {
        this.character = character;
        this.probability = probability;
        this.code = code;
        this.lengthOfCode = code.length();
    }

    public void addSymbolToCode(int symbol){
        this.code+=symbol;
        this.lengthOfCode++;
    }

    public double getProbability() {
        return probability;
    }

    public int getLengthOfCode() {
        return lengthOfCode;
    }

    @Override
    public String toString() {
        return String.format("%9s | %11.5f | %15s | %14d",character,probability,code,lengthOfCode);
    }
}

