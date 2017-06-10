package Alghorithms.Sorting.Trees.DepthFirst;

import java.util.Stack;

public class GraphDF {

    int size;
    DFList[] array;

    public GraphDF(int size) {
        this.size = size;
        array = new DFList[size];
        for (int i = 0; i < size; i++) {
            array[i] = new DFList();
            array[i].head = null;
        }
    }

    public void addNode(int Source, int value) {
        NodeDF n = new NodeDF(value, null);
        n.next = array[Source].head;
        array[Source].head = n;

    }

    public void DFSExplore(int StartVertex) {

        Boolean[] Visited = new Boolean[size];
        for (int i = 0; i < Visited.length; i++) {
            Visited[i] = false;
        }
        Stack<Integer> s = new Stack<Integer>();
        s.push(StartVertex);

        while (!s.isEmpty()) {
            int n = s.pop();
            s.push(n);
            Visited[n] = true;
            NodeDF head = array[n].head;
            Boolean isDone = true;//is visited all node of child
            while (head != null) {
                if (Visited[head.value] == false) {
                    //not visisted
                    s.push(head.value);
                    Visited[head.value] = true;
                    isDone = false;
                    break;
                } else {
                    head = head.next;//if visited go to next child
                }

            }
            if (isDone) {
                int out = s.pop();
                System.out.println("Visited Node " + out);
            }

        }

    }

}
