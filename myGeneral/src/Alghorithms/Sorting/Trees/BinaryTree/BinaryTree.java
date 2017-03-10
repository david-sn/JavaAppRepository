/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alghorithms.Sorting.Trees.BinaryTree;

/**
 *
 * @author David Shire
 */
public class BinaryTree {
    
   
    public Node rootNode=null; // first must is root value
    
    public boolean isEmpty()
    {
        return rootNode==null;
    }
    
    public int Length()
    {
        if (rootNode.isLeaf()) {
            return 1;
        }
        else
        {
            rootNode.Left.isLeaf();
        } 
        return 0;
    }
    
    public void print()
    {
        this.rootNode.print();
    }
    
}
