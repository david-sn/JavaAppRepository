package Alghorithms.DS.HashTable;

import static javafx.scene.input.KeyCode.T;

public class HashArray<T> {

    Entery[] arrayHash;
    int size;

    public HashArray(int size) {
        this.size = size;

        arrayHash = new Entery[this.size];
        for (int i = 0; i < arrayHash.length; i++) {
            arrayHash[i] = new Entery();
        }

    }

    int GetHash(int key) {
        return key % size; //to generate Hash
    }

    public void put(int key, T value) {

        int index = GetHash(key);

        Entery arrayValue = arrayHash[index]; //linked List
        Entery newItem = new Entery<T>(key, value);//create NOde
        newItem.next = arrayValue.next;
        arrayValue.next = newItem;
    }

    public T Get(int key) {
        T value = null;
        int index = GetHash(key);
        Entery arrayValue = arrayHash[index];
        while (arrayValue.next != null) {
            if (arrayValue.getKey() == key) {
                value = (T) arrayValue.getValue();
                break;
            }
            arrayValue = arrayValue.next;
        }
        return value;
    }

}
