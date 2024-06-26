package TADS.LinkedList.src;

public interface MyList<T>{
    public void add(T value);
    public void remove(int position);
    public T get(int position);
    public int size();
    public boolean contains(T value);
    public int search (T value);
    public void AddInOrder(T value);
}
