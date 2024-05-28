package otros;

public class Artista implements Comparable<Artista> {
    String nombre;

    public Artista(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int compareTo(Artista o) {
        return 0;
    }
}
