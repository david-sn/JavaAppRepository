package Alghorithms.Sorting.Trees.BreadthhFirst;

import Alghorithms.Sorting.Trees.DepthFirst.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphBF {

    int size;
    BFList[] array;

    public GraphBF(int size) {
        this.size = size;
        array = new BFList[size];
        for (int i = 0; i < size; i++) {
            array[i] = new BFList();
            array[i].head = null;
        }
    }

    public void addNode(int Source, int value) {
        NodeBF n = new NodeBF(value, null);
        n.next = array[Source].head;
        array[Source].head = n;

    }

    public void BFSExplore(int StartVertex) {

        Boolean[] Visited = new Boolean[size];
        for (int i = 0; i < Visited.length; i++) {
            Visited[i] = false;
        }
        Queue<Integer> s = new LinkedList<Integer>();
        s.add(StartVertex);

        while (!s.isEmpty()) {
            int n = s.poll();
            System.out.println("Visisted  " + n);
            Visited[n] = true;
            NodeBF head = array[n].head;

            while (head != null) {
                if (Visited[head.value] == false) {
                    //not visisted
                    s.add(head.value);
                    Visited[head.value] = true;
                } else {
                    head = head.next;//if visited go to next child
                }

            }

        }

    }

}
