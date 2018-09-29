package com.applied_math;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println("Input file name");
//            Scanner in = new Scanner(System.in);
//            String fileName = in.next();
            String fileName = "hobbit.txt";
            Map<Character, Integer> frequency = FrequencyCalculator.calculateFrequency(fileName);
            List<Map.Entry<Character, Integer>> sortedFrequency = FrequencyCalculator.sortFrequencies(frequency);
            List<Row> table = HuffmanCodeBuilder.generateHuffmanCodes(sortedFrequency);
            table.forEach(System.out::println);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Some io exeption");
        }
    }
}
