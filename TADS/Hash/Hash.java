package TADS.Hash;


public class Hash <K extends Comparable<K>, V>  implements MyHash {
    private int size;
    private int capacity;
    private NodoHash<K,V>[] table;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public NodoHash<K, V>[] getTable() {
        return table;
    }

    public void setTable(NodoHash<K, V>[] table) {
        this.table = table;
    }

    public Hash(){
        this.capacity=12689;
        this.table = new NodoHash[capacity];
        this.size = 0;
    }

    @Override
    public boolean contains(Object key) {
        if (key == null) {
            return false;
        }
        int index =hash((K) key);
        while (table[index] != null) {
            if (table[index].key.equals(key)) {
                return true;
            }
            index = (index + 1);
            if(index>capacity){
                index=0;
            }
        }
        return false;
    }

    @Override
    public void put(Object key, Object value) {

    }

    @Override
    public boolean remove(Object key) {
        return false;
    }


    private void resize() {
        NodoHash<K, V>[] oldTable = table;
        table = new NodoHash[this.getCapacity()*2];
        capacity = newCapacity;
        size = this.getSize();

        for (NodoHash<K, V> node : oldTable) {
            if (node != null) {
                put(node.key, node.value);  // Rehash los elementos en la nueva tabla
            }
        }
    }

    private int hash(K key) {
        return (key.hashCode()) % capacity;
    }
}