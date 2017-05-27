package Alghorithms.DS.LinkList;

public class LinkService {

    Node head;

    public LinkService(Node head) {
        this.head = head; //define first node in system
    }
    
    
    public void add(Node newNode){
    
        newNode.next=head;
        head=newNode;
    }

    public void deleteFirst(){
        head=head.next;
    }

    public void Display(){
    Node n=head;
    while(n !=null){
        System.out.println(n.value);
        n=n.next;
    }
    
    }
    
    
}
