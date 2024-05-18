import TADS.LinkedList.src.MyList;

public class Cancion {
    MyList<Artista> listaDeArtistas;
    String nombreCancion;
    int top;
    float duracion;

    public Cancion(MyList<Artista> listaDeArtistas, String nombreCancion, float duracion) {
        this.listaDeArtistas = listaDeArtistas;
        this.nombreCancion = nombreCancion;
        this.duracion= duracion;
        this.top= 0;
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

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }
}
