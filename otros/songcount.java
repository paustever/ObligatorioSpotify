package otros;

import java.util.Objects;

public class songcount <V> implements Comparable<songcount> {
        V value;
        int count;
        public songcount(V value , int count) {
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
        songcount songcount = (songcount) o;
        return Objects.equals(value, songcount.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(songcount o) {
        if (this.getCount()> o.getCount()){
            return 1;
        }else if (this.getCount()<o.getCount()){
            return -1;
        }else {
            return 0;
        }
    }
}

