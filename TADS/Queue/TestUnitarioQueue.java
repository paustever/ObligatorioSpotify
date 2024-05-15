package TADS.Queue;

import TADS.LinkedList.src.LinkedList;
import TADS.LinkedList.src.MyList;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestUnitarioQueue {
    @Test
    public void validarenqueue(){
        MyQueue<Integer> myQueue= new LinkedQueue<Integer>();
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
    }

    public boolean validar(MyQueue<Integer> resultado, MyList<Integer> expected) {
        MyList <Integer> listaDeLaCola = new LinkedList<>();
        while (!resultado.isEmpty()) {
            try {
                listaDeLaCola.add(resultado.dequeue());
            } catch (EmptyQueueException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
