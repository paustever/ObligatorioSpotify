package TADS.LinkedList.src;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUnitariosLinedList {
    @Test
    public void testAddandGet(){
        MyList<Integer> milista= (MyList<Integer>) new LinkedList<Integer>();
        milista.add(1);
        milista.add(2);
        milista.add(3);
        assertEquals(1, milista.get(0));
        assertEquals(2, milista.get(1));
        assertEquals(3, milista.get(2));
        assertEquals(null, milista.get(3));
    }
    @Test
    public void validarremouve (){
        MyList<Integer> milista=new LinkedList<Integer>();
        milista.add(1);
        milista.add(2);
        milista.add(3);
        milista.remove(1);
        assertEquals(1, milista.get(0));
        assertEquals(3, milista.get(1));
        assertEquals(null, milista.get(2));
    }

    public boolean validar(MyList<Integer> resultado, List<Integer> expected) {
        if (resultado.size() != expected.size()) {
            return false;
        }
        for (int i = 0; i < resultado.size(); i++) {
            if (!resultado.get(i).equals(expected.get(i))) {
                return false;
            }
        }
        return true;
    }

}
