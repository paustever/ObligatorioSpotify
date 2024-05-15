package TADS.Queue;

import TADS.LinkedList.src.Node;
import TADS.Queue.MyQueue;

public class LinkedQueue <T>  implements MyQueue {
    private Node<T> front;
    private Node<T> last;

    public LinkedQueue() {
        this.front = null;
        this.last = null;
    }

    public Node<T> getFront() {
        return front;
    }

    public void setFront(Node<T> front) {
        this.front = front;
    }

    public Node<T> getLast() {
        return last;
    }

    public void setLast(Node<T> last) {
        this.last = last;
    }

    @Override
    public void enqueue(Object element) {
        Node<T> newNode = (Node<T>) new Node<Object>(element);
        if (isEmpty()){
            front = newNode;
            last= newNode;
        }else {
            last.setSiguiente(newNode);
            last= newNode;
        }
    }

    @Override
    public Object dequeue() throws EmptyQueueException {
        if (isEmpty()){
            System.out.println("la cola esta vacia");
            throw new EmptyQueueException();
        }
        Node<T> dequeueNode = front ;
        front= front.getSiguiente();
        if (front == null ){
            last = null ;
        }
        return dequeueNode.getValue();
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }


}

