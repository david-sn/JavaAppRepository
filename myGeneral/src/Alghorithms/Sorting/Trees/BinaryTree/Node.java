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
public class Node {
     
    public char value;
    
    public Node Left , 
                Right; //pointer to point another node
    
    public boolean isLeaf(){
    return (this.Left==null   &&  this.Right==null); // node has NO child this mean leaf node (end node)
    }

    //pre order {root-left-right}
    //in ordwe [left-root -right]
    //post order[left-right-root]
    public void print ()
    {
        //preorder
        System.out.println(value);
        
        //left
        if (this.Left!=null) 
            this.Left.print();
        
        //right
        if (this.Right!=null) 
            this.Right.print();
    }
    
}
