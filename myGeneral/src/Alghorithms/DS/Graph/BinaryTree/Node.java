package Alghorithms.DS.Graph.BinaryTree;

public class Node<T> {

    T value;
    Node leftNode;
    Node rightNode;

    public Node(T value, Node leftNode, Node rightNode) {
        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

}
