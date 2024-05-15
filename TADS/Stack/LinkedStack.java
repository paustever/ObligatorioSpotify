package TADS.Stack;


public class LinkedStack<T extends Comparable<T>> implements MyStack {
        private Node<T> top;

        public LinkedStack() {
            this.top = this.top;
        }

        public Node<T> getTop() {
            return this.top;
        }

        public void setTop(Node<T> top) {
            this.top = top;
        }

        public void pop() throws EmptyStackException {
            if (this.top == null) {
                throw new EmptyStackException();
            } else {
                this.top = this.top.getSiguiente();
            }
        }

        public boolean isEmpty() {
            return this.top == null;
        }

        public void makeEmpty() {
            this.top = null;
        }

        public T top() throws EmptyStackException {
            if (this.isEmpty()) {
                throw new EmptyStackException();
            } else {
                return (Comparable)this.top.getValue();
            }
        }

        public void push(Object element) {
            Node newNode = new Node(element);
            newNode.setSiguiente(this.top);
            this.top = newNode;
        }
    }
}
