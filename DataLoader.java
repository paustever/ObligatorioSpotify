import TADS.Hash.Hash;
import TADS.Hash.IllegalArgumentException;
import TADS.Hash.MyHash;
import TADS.LinkedList.src.LinkedList;
import TADS.LinkedList.src.MyList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

public class DataLoader {
    MyList< Artista> listadeArtistasGeneral = (MyList<Artista>) new LinkedList<Artista>();

    public DataLoader() {
        this.listadeArtistasGeneral = null;
    }
    public MyHash<String, MyHash<String,  MyHash<String, Cancion>>> cargarDatosEnHashMap(String archivoCSV) {
        Hash<String, MyHash<String, MyHash<String, Cancion>>> resultado = new Hash<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                MyList<String> datos = parsearLineaCSV(linea);
                String spotifyId = datos.get(0);
                String nombre = datos.get(1);
                String artistas = datos.get(2);
                String[] artista = artistas.split(",");
                MyList<Artista> listaDeArtistas = null;
                for (String esteArtista : artista) {
                    Artista artistaNuevo= null;
                    for (int i = 0 ; i<listadeArtistasGeneral.size(); i ++){
                        if ( listaDeArtistas.get(i).getNombre() == esteArtista ){
                            artistaNuevo= listaDeArtistas.get(i);
                            listaDeArtistas.add(artistaNuevo);
                        }
                    }
                    artistaNuevo = new Artista(esteArtista);
                    listaDeArtistas.add(artistaNuevo);
                }
                int dailyRank = Integer.parseInt(datos.get(3));
                int dailyMovement = Integer.parseInt(datos.get(4));
                int weeklyMovement = Integer.parseInt(datos.get(5));
                String pais = datos.get(6);
                LocalDate snapshotDate= LocalDate.parse(datos.get(7));
                float tempo = Float.parseFloat(datos.get(23));
                Cancion cancion = new Cancion(spotifyId, listaDeArtistas, nombre,dailyRank,dailyMovement,weeklyMovement, pais,snapshotDate,tempo);
                String dia = String.valueOf(snapshotDate);
                if (!resultado.contains(dia)) {
                    resultado.put(dia, new Hash<>());
                }
                MyHash<String, MyHash<String, Cancion>> countryMap = resultado.get(dia);

                if (!countryMap.contains(pais)) {
                    countryMap.put(pais, new Hash<>());
                }
                MyHash<String, Cancion> songMap = countryMap.get(pais);
                songMap.put(spotifyId, cancion);
            }

        } catch (IOException | IllegalArgumentException  e) {
            System.out.println("hubo algun problema");
        }

        return resultado;
    }


    private MyList<String> parsearLineaCSV(String linea) {
        MyList<String> campos = new TADS.LinkedList.src.LinkedList<>();
        StringBuilder campoActual = new StringBuilder();
        boolean dentroDeComillas = false;
        for (char c: linea.toCharArray()){
            if (c =='"'){
                dentroDeComillas= !dentroDeComillas;
            } else if (c == ',' && !dentroDeComillas) {
                campos.add(campoActual.toString());
                campoActual= new StringBuilder();
            }else {
                campoActual.append(c);
            }
        }
        campos.add(campoActual.toString());
        return campos;
    }
}



