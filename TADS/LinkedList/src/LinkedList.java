package TADS.LinkedList.src;

public class LinkedList<T extends Comparable<T>> implements MyList<T> {
    private Node<T> primero;

    public Node<T> getPrimero() {
        return primero;
    }

    public void setPrimero(Node<T> primero) {
        this.primero = primero;
    }

    public LinkedList() {
    }

    @Override
    public void add(T value) {
        Node<T> X = this.primero;
        Node<T> nuevo = new Node<T>(value);
        if (X == null) {
            this.setPrimero(nuevo);
        } else {
            while (X.getSiguiente() != null) {
                X = X.getSiguiente();
            }
            X.setSiguiente(nuevo);
        }
    }

    @Override
    public void remove(int position) {
        Node<T> X = this.getPrimero();
        if (position == 0) {
            this.setPrimero(X.getSiguiente());
        } else {
            for (int i = 0; i < (position - 1); i++) {
                X = X.getSiguiente();
            }
            Node<T> tempeliminado = X.getSiguiente();
            X.setSiguiente(tempeliminado.getSiguiente());
        }
    }


    @Override
    public T get(int position) {
        Node<T> temp = this.getPrimero();
        for (int i = 0; i < position; i++) {
            if (temp == null) {
                return null;
            }
            temp = temp.getSiguiente();
        }
        if (temp != null) {
            return (T) temp.getValue();
        }
        return null;
    }

    @Override
    public int size() {
        Node<T> temp = this.getPrimero();
        int size = 0;
        if (temp == null) {
            return size;
        } else {
            while (temp != null) {
                size += 1;
                temp = (Node<T>) temp.getSiguiente();
            }
        }
        return size;
    }


    @Override
    public boolean contains(T value) {
        Node<T> temp = this.primero;
        while (temp != null && !temp.getValue().equals(value)) {
            temp = temp.getSiguiente();
        }
        if (temp == null) { // Si no se llego al final de la lista, se encontro el valor
            return false;
        }
        return true;
    }

    @Override
    public int search(T value) {
        int indice = 0;
        Node<T> temp = this.primero;
        while (temp != null && !temp.getValue().equals(value)) {
            indice++;
            temp = temp.getSiguiente();
        }
        if (temp == null) { // Si no se llego al final de la lista, se encontro el valor
            return -1;
        }
        return indice;
    }

    public void AddInOrder(T value) {
        Node<T> newNode = new Node<>(value);

        // Si la lista está vacía o el valor a insertar es menor que el primer valor
        if (primero == null || value.compareTo(primero.getValue()) < 0) {
            newNode.setSiguiente(primero);
            setPrimero(newNode);
            return;
        }

        Node<T> temp = primero;

        // Recorre la lista hasta encontrar la posición correcta para insertar
        while (temp.getSiguiente() != null && value.compareTo(temp.getSiguiente().getValue()) > 0) {
            temp = temp.getSiguiente();
        }

        // Inserta el nuevo nodo en la posición encontrada
        newNode.setSiguiente(temp.getSiguiente());
        temp.setSiguiente(newNode);
    }
}

