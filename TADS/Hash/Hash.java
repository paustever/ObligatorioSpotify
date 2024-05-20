package TADS.Hash;

import TADS.LinkedList.src.MyList;

public class Hash <K extends Comparable<K>, V>  implements MyHash {
    private int size;
    private int capacity;
    private MyList<NodoHash> valores;
    private NodoHash<K,V>[] tablaHash;



    public Hash(){
        this.capacity=12689;
    }

    @Override
    public boolean contains(Object key) {

        return false;
    }

    @Override
    public void put(Object key, Object value) {

    }

    @Override
    public boolean remove(Object key) {
        return false;
    }
}