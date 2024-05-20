package TADS.Hash;

public interface MyHash<K,V> {
    boolean contains(K key);
    void put (K key, V value);
    boolean remove (K key);
}
