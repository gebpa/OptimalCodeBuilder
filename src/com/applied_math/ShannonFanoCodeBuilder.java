package com.applied_math;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShannonFanoCodeBuilder {

    public static List<Row> generateShannonFanoCodes(List<Map.Entry<Character, Integer>> frequency) {
        int total = frequency.stream()
                .mapToInt(Map.Entry::getValue)
                .sum();
        List<Row> table = frequency.stream()
                .map(entry -> new Row(entry.getKey(), (double) entry.getValue() / total))
                .collect(Collectors.toList());
        assignCodes(frequency, table, total, 0, frequency.size() - 1);
        List<Row> sortedTable = table.stream()
                .sorted(Comparator.comparing(Row::getProbability).reversed())
                .collect(Collectors.toList());
        return sortedTable;
    }

    private static void assignCodes(List<Map.Entry<Character, Integer>> frequency, List<Row> table, int total, int first, int last) {
        double closestToHalf = total / 2;
        int sum = 0;
        for (int i = first; i < last + 1; i++) {
            sum += frequency.get(i).getValue();
            double distanceToHalf = Math.abs(total / 2 - sum);
            if (distanceToHalf < closestToHalf) {
                closestToHalf = distanceToHalf;
                table.get(i).addSymbolToCode(1);
            } else {
                sum -= frequency.get(i).getValue();
                for (int t = i; t < last + 1; t++) {
                    table.get(t).addSymbolToCode(0);
                }
                if (first != i - 1) {
                    assignCodes(frequency, table, sum, first, i - 1);

                    if (last != i) {
                        assignCodes(frequency, table, total - sum, i, last);
                    }
                    break;
                }
            }

        }
    }
}
