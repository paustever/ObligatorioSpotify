package TADS.Hash;


import TADS.LinkedList.src.LinkedList;
import TADS.LinkedList.src.MyList;

public class Hash <K extends Comparable<K>, V>  implements MyHash <K,V> {
    private int size;
    private int capacity;
    private NodoHash<K, V>[] table;
    private static final float loadfactor = 0.77F;

    public int getCapacity() {
        return capacity;
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
    public boolean contains(K key) {
        if (key == null) {
            return false;
        }
        int contador = capacity;
        int index = hash(key);
        while (contador != 0) {
            if (table[index] != null) {
                if (table[index].key.equals(key)) {
                    return true;
                }
            }
            index++;
            contador--;
            if (index > capacity-1) {
                index = 0;
            }

        }
        return false;
    }

    @Override
    public void put(K key, V value) throws IllegalArgumentException {
        if (key == null || value == null) {
            throw new IllegalArgumentException();
        }
        if (size >= capacity * loadfactor) {
            resize();
        }
        int index = hash((K) key);
        while (table[index] != null) {
            if (table[index].key.equals(key)) {
                throw new IllegalArgumentException();
            }
            index = (index + 1);
            if (index > capacity - 1) {
                index = 0;
            }
        }
        table[index] = new NodoHash<>((K) key, (V) value);
        size++;
    }


    @Override
    public boolean remove(K key) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        int index = hash(key);
        if (this.contains(key)) {
            boolean buscar = true;
            while (buscar) {
                if (table[index] != null) {
                    if (table[index].key.equals(key)) {
                        table[index] = null;
                        size--;
                        return true;
                    } else {
                        index++;
                        if (index > capacity - 1) {
                            index = 0;
                        }
                    }
                }
            }
        }
        System.out.println("Se lanzo excepcion OK");
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

