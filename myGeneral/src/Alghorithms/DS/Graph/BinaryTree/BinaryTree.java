package Alghorithms.DS.Graph.BinaryTree;

public class BinaryTree<T> {

    Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    public void AddNode(Node newNode, Node rootExplore) {

        if ((Integer) newNode.value > (Integer) rootExplore.value) {
            if (rootExplore.rightNode == null) {
                rootExplore.rightNode = newNode;
            } else {
                AddNode(newNode, rootExplore.rightNode);
            }
        }

        if ((Integer) newNode.value < (Integer) rootExplore.value) {
            if (rootExplore.rightNode == null) {
                rootExplore.rightNode = newNode;
            } else {
                AddNode(newNode, rootExplore.leftNode);
            }
        }
        if (rootExplore == null) {
            return;
        }

    }

    public void SearchNode(T value, Node rootExplore) {

        if ((Integer) value > (Integer) rootExplore.value) {
            if (rootExplore.rightNode == null) {

                SearchNode(value, rootExplore.rightNode);

            }

            if ((Integer) value < (Integer) rootExplore.value) {
                if (rootExplore.rightNode == null) {

                    SearchNode(value, rootExplore.leftNode);

                }
                if (rootExplore == null) {
                    return;//notfound
                }

            }

        }
    }
}
