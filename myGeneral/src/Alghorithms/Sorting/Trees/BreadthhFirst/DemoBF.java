/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alghorithms.Sorting.Trees.BreadthhFirst;

import Alghorithms.Sorting.Trees.DepthFirst.GraphDF;

/**
 *
 * @author David Shire
 */
public class DemoBF {

    public static void main(String[] args) {

        GraphBF g = new GraphBF(6);
        g.addNode(0, 2);
        g.addNode(0, 1);
        g.addNode(1, 4);
        g.addNode(1, 3);
        g.addNode(1, 0);
        g.addNode(3, 1);
        g.addNode(4, 1);
        g.addNode(2, 5);
        g.addNode(2, 0);
        g.addNode(5, 2);

        g.BFSExplore(0);

    }
}
