import TADS.LinkedList.src.MyList;

import java.time.LocalDate;

public class Cancion {
    MyList<Artista> listaDeArtistas;
    String nombreCancion;
    int dailyRank;
    int dailyMovement;
    int weeklyMouvement;
    String pais;
    LocalDate snaphot_date;
    float tempo;


    public Cancion(String spotifyId, MyList<Artista> listaDeArtistas, String nombreCancion, int dailyRank, int dailyMovement, int weeklyMouvement, String pais, LocalDate snaphot_date, float tempo) {
        this.listaDeArtistas = listaDeArtistas;
        this.nombreCancion = nombreCancion;
        this.dailyRank = dailyRank;
        this.dailyMovement = dailyMovement;
        this.weeklyMouvement = weeklyMouvement;
        this.pais = pais;
        this.snaphot_date = snaphot_date;
        this.tempo = tempo;
    }

    public MyList<Artista> getListaDeArtistas() {
        return listaDeArtistas;
    }

    public void setListaDeArtistas(MyList<Artista> listaDeArtistas) {
        this.listaDeArtistas = listaDeArtistas;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

}
