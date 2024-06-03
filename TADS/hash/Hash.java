package TADS.hash;


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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setTable(NodoHash<K, V>[] table) {
        this.table = table;
    }

    @Override
    public boolean contains(K key) {
        if (key == null || capacity == 0) {
            return false;
        }

        int index = Math.abs(hash(key)) % capacity; // Calcula el índice usando el módulo de la capacidad
        int initialIndex = index;
        do {
            if (table[index] != null && table[index].key.equals(key)) {
                return true; // La clave se encontró en esta posición
            }
            index = (index + 1) % capacity; // Avanza al siguiente índice circularmente
        } while (index != initialIndex && table[index] != null); // Salir del bucle si se vuelve al índice inicial o se alcanza un espacio nulo

        return false; // La clave no se encontró en la tabla
    }

    @Override
    public void put(K key, V value) throws IllegalArgumentException {
        if (key == null || value == null) {
            throw new IllegalArgumentException();
        }
        if (size >= capacity * loadfactor) {
            resize();
        }
        int index = Math.abs(hash((K) key));
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

    @Override
    public V get(K key) {
        if (key == null) {
            return null;
        }
        int contador = capacity;
        int index = Math.abs(hash(key));
        while (contador != 0) {
            if (table[index] != null) {
                if (table[index].key.equals(key)) {
                    return table[index].getValue();
                }
            }
            index++;
            contador--;
            if (index > capacity-1) {
                index = 0;
            }
        }
        return null;
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
    public MyList<K> keyset() {
        MyList<K> keys = new LinkedList<>();
        for (NodoHash<K,V> entry : this.getTable()) {
            keys.add(entry.getKey());
        }
        return keys;

}

    @Override
    public int Size() {
        return size;
    }

    private int hash(K key) {
        return (key.hashCode()) % capacity;
    }

}

