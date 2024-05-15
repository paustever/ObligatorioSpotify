package TADS.LinkedList.src;

import TADS.LinkedList.src.LinkedList;
import TADS.LinkedList.src.MyList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUnitariosLinedList {
    @Test
    public void testadd(){
        MyList<Integer> milista= (MyList<Integer>) new LinkedList<Integer>();
        milista.add(1);
        milista.add(2);
        milista.add(3);
        List<Integer> expected= new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        assertEquals(true, validar(milista, expected));
    }
    @Test
    public void validarremouve (){
        MyList<Integer> milista= (MyList<Integer>) new LinkedList<Integer>();
        milista.add(1);
        milista.add(2);
        milista.add(3);
        milista.remove(1);
        List<Integer> expected= new ArrayList<>();
        expected.add(1);
        expected.add(3);
        assertEquals(true, validar(milista, expected));
    }

    @Test
    public void validarget(){
        MyList<Integer> milista= (MyList<Integer>) new LinkedList<Integer>();
        milista.add(1);
        milista.add(2);
        milista.add(3);
        assertEquals(3, milista.get(2));
    }
    @Test
    public void validargetvacio() {
        MyList<Integer> milista = (MyList<Integer>) new LinkedList<Integer>();
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


    public List<Integer> pasaraList(){
        return null;
    }
    public void imprimir(MyList<Integer> lista){
        for (int i =0; i < lista.size(); i++){
            System.out.println(lista.get(i));
        }
    }
    public void imprimir(List<Integer> lista){
        for (int i =0; i < lista.size(); i++){
            System.out.println(lista.get(i));
        }
    }
}

