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

    public int getDailyRank() {
        return dailyRank;
    }

    public void setDailyRank(int dailyRank) {
        this.dailyRank = dailyRank;
    }

    public int getDailyMovement() {
        return dailyMovement;
    }

    public void setDailyMovement(int dailyMovement) {
        this.dailyMovement = dailyMovement;
    }

    public int getWeeklyMouvement() {
        return weeklyMouvement;
    }

    public void setWeeklyMouvement(int weeklyMouvement) {
        this.weeklyMouvement = weeklyMouvement;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public LocalDate getSnaphot_date() {
        return snaphot_date;
    }

    public void setSnaphot_date(LocalDate snaphot_date) {
        this.snaphot_date = snaphot_date;
    }

    public float getTempo() {
        return tempo;
    }

    public void setTempo(float tempo) {
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
