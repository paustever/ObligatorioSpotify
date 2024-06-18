package otros;

import TADS.LinkedList.src.LinkedList;
import TADS.hash.Hash;
import TADS.hash.IllegalArgumentException;
import TADS.hash.MyHash;
import TADS.LinkedList.src.MyList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;


public class DataLoader {
    MyList< Artista> listadeArtistasGeneral;
    public DataLoader() {
        this.listadeArtistasGeneral = new TADS.LinkedList.src.LinkedList<>();
    }

    public MyList<Artista> getListadeArtistasGeneral() {
        return listadeArtistasGeneral;
    }

    public void setListadeArtistasGeneral(MyList<Artista> listadeArtistasGeneral) {
        this.listadeArtistasGeneral = listadeArtistasGeneral;
    }

    public MyList<Hash> cargarDatosEnHashMap(String archivoCSV) {
        MyList listadehashes= new LinkedList<>();
        MyHash<String, MyHash<String, MyHash<Integer, Cancion>>> resultado1 = new Hash<>();
        MyHash<String, MyHash<String,Count<Cancion>>> resultado2=new Hash<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            String linea;
            br.readLine();
            int contador = 0;
            while ((linea = br.readLine()) != null) {
                contador++;
               MyList<String> datos = split(linea,"\",\"");
                String spotifyId = datos.get(0).replace("\"", "");
                String nombre = datos.get(1);
                String artistas = datos.get(2);
                String[] artista = artistas.split(",");
                MyList<Artista> listaDeArtistas = new LinkedList<>();
                for (String esteArtista : artista) {
                    Artista artistaNuevo= null;
                    for (int i = 0 ; i<listadeArtistasGeneral.size(); i ++){
                        if ( listaDeArtistas.get(i).getNombre().equals(esteArtista)){
                            artistaNuevo= listaDeArtistas.get(i);
                            listaDeArtistas.add(artistaNuevo);
                            if(!listadeArtistasGeneral.contains(artistaNuevo)){
                                listadeArtistasGeneral.add(artistaNuevo);
                            }
                        }
                    }
                    artistaNuevo = new Artista(esteArtista);
                    listaDeArtistas.add(artistaNuevo);
                }
                System.out.println(datos);
                int dailyRank = Integer.parseInt(datos.get(3));
                int dailyMovement = Integer.parseInt(datos.get(4));
                int weeklyMovement = Integer.parseInt(datos.get(5));
                String pais = datos.get(6);
                if (pais ==""){
                    pais = "global";
                }
                LocalDate snapshotDate= LocalDate.parse(datos.get(7));
                float tempo = Float.parseFloat(datos.get(23));
                Cancion cancion = new Cancion(spotifyId, listaDeArtistas, nombre,dailyRank,dailyMovement,weeklyMovement, pais,snapshotDate,tempo);
                Count<Cancion> songcount =new Count(cancion,1);
                String dia = String.valueOf(snapshotDate);
                if (!resultado1.contains(dia)) {
                    resultado1.put(dia, new Hash<>());
                }
                MyHash<String, MyHash<Integer, Cancion>> countryMap = resultado1.get(dia);

                if (!countryMap.contains(pais)) {
                    countryMap.put(pais, new Hash<>());
                }
                MyHash<Integer, Cancion> songMap = countryMap.get(pais);
                songMap.put(dailyRank, cancion);

                if(!resultado2.contains(dia)){
                    resultado2.put(dia,new Hash<>());
                }
                if(!resultado2.get(dia).contains((songcount.getValue().getSpotifyId()))){
                    resultado2.get(dia).put(spotifyId,songcount);
                }else{
                    Count micount= (Count) resultado2.get(spotifyId);
                    int valor=micount.getCount()+1;
                    micount.setCount(valor);
                }
            }
        } catch (IOException | IllegalArgumentException  e) {
            System.out.println("hubo algun problema");
        }
        listadehashes.add((Hash) resultado1);
        listadehashes.add((Hash) resultado2);

        return listadehashes;
    }


    private static MyList<String> split(String cadena, String separador) {
        MyList<String> lista = new LinkedList<>();
        int indiceInicio = 0;
        int indiceSeparador;

        // Iterar mientras haya separadores en la cadena
        while ((indiceSeparador = cadena.indexOf(separador, indiceInicio)) != -1) {
            // Agregar la subcadena entre el índice de inicio y el índice del separador a la lista
            lista.add(cadena.substring(indiceInicio, indiceSeparador));
            // Actualizar el índice de inicio para comenzar la próxima búsqueda después del separador
            indiceInicio = indiceSeparador + separador.length();
        }

        // Agregar la última parte de la cadena a la lista
        lista.add(cadena.substring(indiceInicio));

        return lista;
    }
}


