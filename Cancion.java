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
    int popularity;
    boolean isExplicit;
    int durationMs;
    String albumName;
    LocalDate albumReleaseDate;
    int danceability;
    int energy;
    int key;
    int loudness;
    int mode;
    int acoustincness;
    int instrumentalness;
    int liveness;
    int valence;
    int tempo;
    int time_signature;
    float duracion;

    public Cancion(MyList<Artista> listaDeArtistas, String nombreCancion, float duracion) {
        this.listaDeArtistas = listaDeArtistas;
        this.nombreCancion = nombreCancion;
        this.duracion= duracion;
        this.dailyRank= 0;
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

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }
}
