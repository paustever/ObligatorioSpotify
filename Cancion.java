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
    float danceability;
    float energy;
    int key;
    float loudness;
    int mode;
    float acoustincness;
    float instrumentalness;
    float liveness;
    float valence;
    float tempo;
    int time_signature;


    public Cancion(String spotifyId, MyList<Artista> listaDeArtistas, String nombreCancion, int dailyRank, int dailyMovement, int weeklyMouvement, String pais, LocalDate snaphot_date, int popularity, boolean isExplicit, int durationMs, String albumName, LocalDate albumReleaseDate, float danceability, float energy, int key, float loudness, int mode, float acoustincness, float instrumentalness, float liveness, float valence, float tempo, float v, int time_signature) {
        this.listaDeArtistas = listaDeArtistas;
        this.nombreCancion = nombreCancion;
        this.dailyRank = dailyRank;
        this.dailyMovement = dailyMovement;
        this.weeklyMouvement = weeklyMouvement;
        this.pais = pais;
        this.snaphot_date = snaphot_date;
        this.popularity = popularity;
        this.isExplicit = isExplicit;
        this.durationMs = durationMs;
        this.albumName = albumName;
        this.albumReleaseDate = albumReleaseDate;
        this.danceability = danceability;
        this.energy = energy;
        this.key = key;
        this.loudness = loudness;
        this.mode = mode;
        this.acoustincness = acoustincness;
        this.instrumentalness = instrumentalness;
        this.liveness = liveness;
        this.valence = valence;
        this.tempo = tempo;
        this.time_signature = time_signature;
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
