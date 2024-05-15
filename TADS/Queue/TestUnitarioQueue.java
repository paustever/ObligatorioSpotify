package TADS.Queue;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestUnitarioQueue {
    @Test
    public void validarQueueEnqueuDequeu(){
        MyQueue<Integer> myQueue= new LinkedQueue<Integer>();
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        try {
            assertEquals(1, myQueue.dequeue());
            assertEquals(2, myQueue.dequeue());
            assertEquals(3, myQueue.dequeue());
            assertEquals("la cola esta vacia", myQueue.dequeue());
        } catch (EmptyQueueException e){;
        }
    }
    @Test
    public void validarIsEmpty(){
        MyQueue<Integer> myQueue= new LinkedQueue<Integer>();
        assertEquals(true,myQueue.isEmpty());
    }
    @Test
    public  void validarIsNotEmpty(){
        MyQueue<Integer> myQueue= new LinkedQueue<Integer>();
        myQueue.enqueue(1);
        assertEquals(false,myQueue.isEmpty());
    }

}
