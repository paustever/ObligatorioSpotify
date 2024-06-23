package Entities;

import TADS.hash.IllegalArgumentException;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReporteAlmacenamiento {
    public ReporteAlmacenamiento() {
    }

    public void  Reporte() throws FileNotFoundException, IllegalArgumentException {
        long memoriaAntes = getUsedMemory();
        long tiempoinicio = System.nanoTime();
        DataLoader datos = new DataLoader();
        Scanner scanner = new Scanner(System.in);
        System.out.println(tiempoinicio);
        System.out.println(memoriaAntes);
        System.out.println("ponga la direccion donde tiene guardado el archivo q quiere subir");
        String  archivoCSV= scanner.nextLine();
        long memoriaDespues = getUsedMemory();
        datos.cargarDatosEnHashMap(archivoCSV);
        long tiempoFin= System.nanoTime();
        long tiempoCargaDeDatos =tiempoFin- tiempoinicio;
        long MemoriaCargadeDatos = memoriaDespues- memoriaAntes;
        System.out.println(tiempoCargaDeDatos);
        System.out.println(MemoriaCargadeDatos);
    }

    public static long getUsedMemory() {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        return totalMemory - freeMemory;
    }
}
