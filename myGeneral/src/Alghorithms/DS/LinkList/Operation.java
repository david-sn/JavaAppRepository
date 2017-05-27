

package Alghorithms.DS.LinkList;



public class Operation {
    
    public static void main(String[] args) {
        
        LinkService ls=new LinkService(new Node(1,null));
        
        ls.add(new Node(2,null));
        ls.add(new Node(3,null));
        
        ls.Display();
        
    }
}
