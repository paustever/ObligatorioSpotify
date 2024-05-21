package TADS.Hash;

public interface MyHash<K,V> {
    boolean contains(K key);
    void put (K key, V value) throws IllegalArgumentException;
    boolean remove (K key) throws IllegalArgumentException;
}
