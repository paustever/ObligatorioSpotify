package Entities;

import java.util.Objects;

public class Count<V extends Comparable<V>> implements Comparable<Count<V>> {
        V value;
        int count;
        public Count(V value , int count) {
            this.value = value;
            this.count = count;
        }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void setCount(int count) {
        this.count = count;
    }


        public int getCount() {
            return count;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Count songcount = (Count) o;
        return Objects.equals(value, songcount.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(Count o) {
        if (this.getCount()> o.getCount()){
            return 1;
        }else if (this.getCount()<o.getCount()){
            return -1;
        }else {
            return 0;
        }
    }
}

