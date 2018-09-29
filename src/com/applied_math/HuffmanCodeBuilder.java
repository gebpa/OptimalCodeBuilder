package com.applied_math;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HuffmanCodeBuilder {

    public static List<Row> generateHuffmanCodes(List<Map.Entry<Character, Integer>> frequency){
        Node root =buildHuffmanTree(frequency);
        List<Row> table =assignCodes(root);
        List<Row> sortedTable = table.stream()
                .sorted(Comparator.comparing(Row::getProbability).reversed())
                .collect(Collectors.toList());
        return sortedTable;
    }

    private static Node buildHuffmanTree(List<Map.Entry<Character, Integer>> frequency) {
        List<Node> huffmanTree = frequency.stream()
                .map(entry -> new Node(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
        while (huffmanTree.size() != 1) {
            Node newNode = new Node(huffmanTree.remove(1), huffmanTree.remove(0));
            addNode(huffmanTree, newNode);
        }
        return huffmanTree.get(0);
    }

    private static List<Row> assignCodes(Node root) {
        List<Row> table = new ArrayList<>();
        int totalFrequency = root.getFrequncy();
        Node node = root;
        StringBuilder code = new StringBuilder();
        while (root.getLeft() != null || root.getRight() != null) {
            if (node.getLeft() != null){
                node = node.getLeft();
                code.append(1);
            }
            else if(node.getRight()!= null){
                node = node.getRight();
                code.append(0);
            }
            else if (node.getCharacter() != null){
                Row row = new Row(node.getCharacter(), (double)node.getFrequncy()/totalFrequency, new String(code));
                table.add(row);
                node.notAChildAnyMore();
                node = node.getParent();
                code.deleteCharAt(code.length()-1);
            } else {
                node.notAChildAnyMore();
                node = node.getParent();
                code.deleteCharAt(code.length()-1);
            }
        }

        return table;
    }

    private static void addNode(List<Node> list, Node newNode) {
        for (int i = 0; i < list.size(); i++) {
            if (newNode.compareTo(list.get(i)) < 0) {
                list.add(i, newNode);
                return;
            }
        }
        list.add(newNode);
    }
}
