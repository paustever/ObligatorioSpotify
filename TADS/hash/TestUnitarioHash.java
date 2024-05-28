package TADS.hash;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestUnitarioHash <K extends Comparable<K>, V> {
    @Test
    public void pruebas() {
        MyHash<Integer, String> mihash = new Hash<>();
        try {
            mihash.put(1, "A");
        } catch (IllegalArgumentException e) {
            System.out.println("Se lanzo excepcion NO");
            ;
        }
        try {
            mihash.put(1, "A");
        } catch (IllegalArgumentException e) {
            System.out.println("Se lanzo excepcion OK");
            ;
        }
        try {
            mihash.put(2, "A");
        } catch (IllegalArgumentException e) {
            System.out.println("Se lanzo excepcion NO");
        }
        try {
            mihash.remove(1);
        } catch (IllegalArgumentException e) {
            System.out.println("Se lanzo excepcion NO");
        }
        try {mihash.remove(4);
        } catch (IllegalArgumentException e) {
            System.out.println();
        }
        assertEquals(mihash.contains(null), false);
        assertEquals(mihash.contains(1), false);
        assertEquals(mihash.contains(null), false);
        assertEquals(mihash.contains(2), true);


    }
}

