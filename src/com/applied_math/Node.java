package com.applied_math;

public class Node implements Comparable<Node> {
    private Node left;
    private Node right;
    private Node parent;
    private int frequncy;
    private Character character;

    public Node(Node left, Node right) {
        this.frequncy = left.frequncy + right.frequncy;
        this.left = left;
        this.right = right;
        left.parent = this;
        right.parent = this;

    }

    public Node(Character character, int frequncy) {
        this.frequncy = frequncy;
        this.character = character;
        this.right = null;
        this.left = null;
        this.parent = null;
    }

    public void notAChildAnyMore() {
        if (this.parent.getLeft() == this) {
            this.parent.left = null;
        } else this.parent.right = null;

    }

    @Override
    public int compareTo(Node node) {
        return Integer.compare(frequncy, node.frequncy);
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getFrequncy() {
        return frequncy;
    }

    public Character getCharacter() {
        return character;
    }

    public Node getParent() {
        return parent;
    }


}
