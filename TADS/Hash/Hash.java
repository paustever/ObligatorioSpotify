package TADS.Hash;


public class Hash <K extends Comparable<K>, V>  implements MyHash {
    private int size;
    private int capacity;
    private NodoHash<K, V>[] table;
    private static final float loadfactor = 0.77F;


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public NodoHash<K, V>[] getTable() {
        return table;
    }


    public Hash() {
        this.capacity = 12689;
        this.table = new NodoHash[capacity];
        this.size = 0;
    }

    @Override
    public boolean contains(Object key) {
        if (key == null) {
            return false;
        }
        int index = hash((K) key);
        while (table[index] != null) {
            if (table[index].key.equals(key)) {
                return true;
            }
            index = (index + 1);
            if (index > capacity) {
                index = 0;
            }
        }
        return false;
    }

    @Override
    public void put(Object key, Object value) throws IllegalArgumentException {
        if (key == null || value == null) {
            throw new IllegalArgumentException();
        }
        if (size >= capacity * loadfactor) {
            resize();
        }
        int index = hash((K) key);
        while (table[index] != null) {
            if (table[index].key.equals(key)) {
                table[index].setValue((V) value);
                return;
            }
            index = (index + 1) % capacity; // linear probing
        }
        table[index] = new NodoHash<>((K) key, (V) value);
        size++;
    }


    @Override
    public boolean remove(Object key) {
        return false;
    }


    private void resize() throws IllegalArgumentException {
        NodoHash<K, V>[] oldTable = table;
        table = new NodoHash[this.capacity * 2];
        capacity = this.capacity * 2;
        size = 0;

        for (NodoHash<K, V> node : oldTable) {
            if (node != null) {
                put(node.key, node.value);
            }
        }
    }

    private int hash(K key) {
        return (key.hashCode()) % capacity;
    }
}

