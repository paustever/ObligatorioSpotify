package otros;

import TADS.hash.IllegalArgumentException;

import java.io.FileNotFoundException;

public class MainAllmacenamiento {

    public static void main(String[] args) throws FileNotFoundException, IllegalArgumentException {
        ReporteAlmacenamiento reporte = new ReporteAlmacenamiento();
        reporte.Reporte();
    }
}
