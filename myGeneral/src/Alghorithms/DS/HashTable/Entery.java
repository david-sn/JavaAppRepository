package Alghorithms.DS.HashTable;

public class Entery <T>{

    int key;
    T value;
    
    Entery next;

    public Entery() {
        
        this.next = null;
    }

    public Entery(int key, T value) {
        this.key = key;
        this.value = value;
    }

    
    public int getKey() {
        return key;
    }

    public T getValue() {
        return value;
    }
    
    
    
    
}
