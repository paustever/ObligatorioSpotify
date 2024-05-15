package TADS.Stack;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import TADS.LinkedList.src.LinkedList;
import TADS.LinkedList.src.MyList;



    public class TestUnitarioStack <T extends Comparable<T>>{
        @Test
        public void validar() throws EmptyStackException {
            MyStack<Integer> mistack=new LinkedStack();
            mistack.push(1);
            mistack.push(2);
            mistack.push(3);
            MyList<Integer> resultado=new LinkedList();
            while (!mistack.isEmpty()){
                resultado.add(mistack.top());
                mistack.pop();}
            MyList<Integer> expected=new LinkedList();
            expected.add(3);
            expected.add(2);
            expected.add(1);
            for(int i=0; i<=expected.size();i++) {
                assertEquals(expected.get(i), resultado.get(i));
            }

        }
        @Test
        public void makeempty(){
            MyStack<Integer> mistack=new LinkedStack();
            mistack.push(1);
            mistack.push(2);
            mistack.push(3);
            mistack.makeEmpty();
            int i=0;
            while (!mistack.isEmpty()){
                i++;
            }
            assertEquals(i,0);


        }
}
