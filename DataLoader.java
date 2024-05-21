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
    }

    public MyHash<String, Cancion> cargarDatosEnHashMap(String archivoCSV) {
        MyHash<String, Cancion> HashCanciones = new Hash<>();

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
                int popluarity  = Integer.parseInt(datos.get(8));
                boolean isExplicit = Boolean.parseBoolean(datos.get(9));
                int durationMs  = Integer.parseInt(datos.get(10));
                String albumName = datos.get(11);
                LocalDate albumRealeaseDate = LocalDate.parse(datos.get(12));
                float danceability = Float.parseFloat(datos.get(13));
                float energy = Float.parseFloat(datos.get(14));
                int key = Integer.parseInt(datos.get(15));
                float loudness = Float.parseFloat(datos.get(16));
                int mode = Integer.parseInt(datos.get(17));
                float speechiness = Float.parseFloat(datos.get(18));
                float acousticness = Float.parseFloat(datos.get(19));
                float instrumentalness = Float.parseFloat(datos.get(20));
                float liveness = Float.parseFloat(datos.get(21));
                float valence = Float.parseFloat(datos.get(22));
                float tempo = Float.parseFloat(datos.get(23));
                int timeSignature= Integer.parseInt(datos.get(24));
                Cancion cancion = new Cancion(spotifyId, listaDeArtistas, nombre,dailyRank,dailyMovement,weeklyMovement, pais,snapshotDate, popluarity,isExplicit,durationMs,albumName, albumRealeaseDate, danceability,energy, key, loudness, mode,speechiness, acousticness,instrumentalness,liveness,valence, tempo, timeSignature);
                HashCanciones.put(spotifyId, cancion);
            }

        } catch (IOException | IllegalArgumentException  e) {
            System.out.println("hubo algun problema");
        }

        return HashCanciones;
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



