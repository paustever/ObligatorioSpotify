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


    public boolean encontrar(T value) {
        Node<T> X = this.getPrimero();
        while (X != null) {
            if (X.getValue() == value) {
                return true;
            } else {
                X = (Node<T>) X.getSiguiente();
            }
        }
        return false;
    }


    public void addFirst(T value) {
        Node<T> nuevo = new Node<>(value);
        nuevo.setSiguiente(this.primero);
        this.primero = nuevo;
    }

    public void addLast(T value) {
        Node<T> nuevo = new Node<>(value);
        if (this.primero == null) {
            this.primero = nuevo;
        } else {
            Node<T> temp = this.primero;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(nuevo);
        }
    }


    public static void mostrarLista(LinkedList<Integer> lista) {
        Node<Integer> current = lista.getPrimero();
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getSiguiente();
        }
        System.out.println();
    }

    public int getSize() {
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

    public void intercambiar(T object, int direccion) {
        if (primero == null) {
            return;
        }
        Node<T> temp = primero;

        while (temp != null) {
            if (temp.getValue().equals(object)) {
                if (direccion == -1 && temp.getAnterior() != null) {
                    Node<T> anterior = temp.getAnterior();
                    T tempValue = temp.getValue();
                    temp.setValue(anterior.getValue());
                    anterior.setValue(tempValue);
                    return;
                } else if (direccion == 1 && temp.getSiguiente() != null) {
                    Node<T> siguiente = temp.getSiguiente();
                    T tempValue = temp.getValue();
                    temp.setValue(siguiente.getValue());
                    siguiente.setValue(tempValue);
                    return;
                }
            }
            temp = temp.getSiguiente();
        }
    }

    public void visualizar(MyList<Integer> P) {
        int i =0 ;
        while (P.get(i)!= null ){
            Integer pos = P.get(i);
            if (this.get(pos)!= null ){
                System.out.println(this.get(pos));
            }
            i ++ ;
        }
    }






    public void addInOrder(T value) {
        Node<T> newNode = new Node<>(value);
        if (primero == null || value.compareTo(primero.getValue()) < 0) {
            newNode.setSiguiente((Node<T>) primero);
            setPrimero(newNode);
            return;
        }
        Node<T> temp = this.getPrimero();
        while (temp.getSiguiente() != null && value.compareTo((T) temp.getSiguiente().getValue()) > 0) {
            temp = (Node<T>) temp.getSiguiente();
        }
        newNode.setSiguiente((Node<T>) temp.getSiguiente());
        temp.setSiguiente(newNode);
    }
    public LinkedList<T> append(LinkedList<T> lista2) {
        LinkedList<T> result = new LinkedList<>();
        Node<T> temp = this.getPrimero();
        while (temp != null) {
            if (lista2.contains(temp.getValue())){
                result.add(temp.getValue());
            }
            temp = temp.getSiguiente();
        }
        return result;
    }


    public LinkedList union (LinkedList lista2){
        LinkedList result = new LinkedList();
        Node temp = primero;
        Node temp2 = lista2.getPrimero();
        while (temp != null ){
            if ( ! lista2.contains((Comparable) temp.getValue())){
                result.add((T) temp.getValue());
            }
            temp= temp.getSiguiente();
        }
        while (temp2!= null){
            if (! this.contains((T) temp2.getValue())){
                result.add((T) temp2.getValue());
            }
            temp2= temp2.getSiguiente();
        }
        return result;
    }

    private boolean contains (T value  ){
        Node<T> temp = primero;
        while (temp!= null){
            if (temp.getValue() == value  ){
                return true ;
            }
            temp= temp.getSiguiente();
        }
        return false ;
    }
//    public linkedList positivos (){
//        linkedList result = new linkedList();
//        Node temp = primero;
//        Node newNode = new Node;
//        while (temp != null ){
//            if (temp.getValue() 0 ){
//                newNode.setValue(temp.getValue());
//                if (result.getPrimero()== null ){
//                    result.setPrimero(newNode);
//                }
//                temp = temp.getSiguiente();
//            }
//        }
//        return result ;
//    }
}
