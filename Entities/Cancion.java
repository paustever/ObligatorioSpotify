package Entities;

import TADS.LinkedList.src.MyList;

import java.time.LocalDate;
import java.util.Objects;

public class Cancion implements Comparable<Cancion> {
    String spotifyId;
    MyList<Artista> listaDeArtistas;
    String nombreCancion;
    int dailyRank;
    int dailyMovement;
    int weeklyMouvement;
    String pais;
    LocalDate snaphot_date;
    float tempo;


    public Cancion(String spotifyId, MyList<Artista> listaDeArtistas, String nombreCancion, int dailyRank, int dailyMovement, int weeklyMouvement, String pais, LocalDate snaphot_date, float tempo ) {
        this.spotifyId= spotifyId;
        this.listaDeArtistas = listaDeArtistas;
        this.nombreCancion = nombreCancion;
        this.dailyRank = dailyRank;
        this.dailyMovement = dailyMovement;
        this.weeklyMouvement = weeklyMouvement;
        this.pais = pais;
        this.snaphot_date = snaphot_date;
        this.tempo = tempo;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cancion cancion = (Cancion) o;
        return Objects.equals(spotifyId, cancion.spotifyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(spotifyId);
    }

    public String getSpotifyId() {
        return spotifyId;
    }

    public void setSpotifyId(String spotifyId) {
        this.spotifyId = spotifyId;
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

    @Override
    public String toString() {
        return "Cancion{" +
                "spotifyId='" + spotifyId + '\'' +
                ", listaDeArtistas=" + listaDeArtistas +
                ", nombreCancion='" + nombreCancion + '\'' +
                ", dailyRank=" + dailyRank +
                ", dailyMovement=" + dailyMovement +
                ", weeklyMouvement=" + weeklyMouvement +
                ", pais='" + pais + '\'' +
                ", snaphot_date=" + snaphot_date +
                ", tempo=" + tempo +
                '}';
    }

    public StringBuilder imprimirlista(){
        StringBuilder varibale=new StringBuilder();
        for (int i=0; i<listaDeArtistas.size();i++){
            varibale.append(" " + listaDeArtistas.get(i).getNombre());
        }
        return varibale;

    }

    @Override
    public int compareTo(Cancion o) {
            if (this.getDailyRank()> o.getDailyRank()){
                return 1;
            }else if (this.getDailyRank()<o.getDailyRank()){
                return -1;
            }else {
                return 0;
            }
        }
    }


