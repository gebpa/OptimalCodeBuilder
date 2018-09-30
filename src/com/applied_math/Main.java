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
            List<Row> tableHuffman = HuffmanCodeBuilder.generateHuffmanCodes(sortedFrequency);
            List<Row> tableShannonFano=ShannonFanoCodeBuilder.generateShannonFanoCodes(sortedFrequency);
            System.out.println("Huffman code");
            System.out.println("Character | Probability |            Code | Length of code");
            tableHuffman.forEach(System.out::println);
            System.out.println("Shannon-Fano code");
            System.out.println("Character | Probability |            Code | Length of code");
            tableShannonFano.forEach(System.out::println);
            System.out.println();
            System.out.println("Initial file | Huffman code | Shannon-Fano code");
            double huffmanAverage=EntropyCalculator.getAverageLengthOfCode(tableHuffman);
            double shannonFanoAverage=EntropyCalculator.getAverageLengthOfCode(tableShannonFano);
            double entropy = EntropyCalculator.getEntropy(tableHuffman);
            System.out.printf("%12.4f | %12.4f | %17.4f", entropy, huffmanAverage, shannonFanoAverage);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Some io exeption");
        }
    }
}
