package TADS.LinkedList.src;

public interface MyList<T>{
    public void add(T value);
    public void remove(int position);
    public T get(int position);
    public int size();
}
