package TADS.Hash;

import java.util.Objects;

public class NodoHash <K extends Comparable<K>, V>{
    K key;
    V value;


    public NodoHash(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
