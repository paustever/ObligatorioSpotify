import java.util.Objects;

public class Node<T> {
    private T value;
    private Node <T> siguiente;
    private Node<T> anterior;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getSiguiente() {
        return siguiente;
    }

    public Node<T> getAnterior() {return anterior;}

    public void setValue(T value) {
        this.value = value;
    }

    public void setSiguiente(Node<T> siguiente) {this.siguiente = siguiente;}

    public void setAnterior(Node<T> anterior) {
        this.anterior = anterior;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(value, node.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, siguiente, anterior);
    }
}
