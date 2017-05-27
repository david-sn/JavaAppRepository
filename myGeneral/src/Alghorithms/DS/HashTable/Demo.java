
package Alghorithms.DS.HashTable;
public class Demo {

    public static void main(String[] args) {
        
        HashArray<String> hash=new  HashArray<String>(10);
        hash.put(10, "david");
        hash.put(20, "shiref");
        
        System.out.println(hash.Get(20));
    }
    
}
