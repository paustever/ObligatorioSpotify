package otros;

import TADS.hash.Hash;
import TADS.hash.MyHash;
import TADS.LinkedList.src.MyList;
import TADS.Tree.BinarySearchTree;
import TADS.Tree.MyBinarySearchTree;
import java.time.LocalDate;

public class ConsultasSpotify implements Consultas {
    MyHash<String, MyHash<String, MyHash<String, Cancion>>> miHash;

    public ConsultasSpotify(MyHash datos) {
        this.miHash = datos;
    }

    public MyHash<String, MyHash<String, MyHash<String, Cancion>>> getMiHash() {
        return miHash;
    }

    public void setMiHash(MyHash<String, MyHash<String, MyHash<String, Cancion>>> miHash) {
        this.miHash = miHash;
    }

    public MyList<Cancion> Top10(String pais, LocalDate dia) {
        String diaString = String.valueOf(dia);
        MyBinarySearchTree Top = new BinarySearchTree(null);
        if (miHash == null) {
            return null;
        } else if (miHash.contains(diaString)) {
            Hash HashPais = (Hash) miHash.get(diaString);
            if (HashPais.contains(pais)) {
                Hash HashCanciones = (Hash) HashPais.get(pais);
                for (int i = 0; i < HashCanciones.getSize(); i++) {
                    Cancion candionTemp = (Cancion) HashCanciones.getTable()[i].getValue();
                    if (candionTemp.getDailyRank() <= 10) {
                        Top.insert(candionTemp.dailyRank, candionTemp);
                    }
                }
            }
        }
        MyList<Cancion> TopOrdenado = Top.inOrder();
        for (int i = 0; i < TopOrdenado.size(); i++) {
            System.out.println("Top 10 canciones mas escuchadas en " + pais + " en el dia " + dia);
            System.out.println("1. " + TopOrdenado.get(0).getNombreCancion() + TopOrdenado.get(0).getListaDeArtistas());
            System.out.println("2. " + TopOrdenado.get(1).getNombreCancion() + TopOrdenado.get(1).getListaDeArtistas());
            System.out.println("3. " + TopOrdenado.get(2).getNombreCancion() + TopOrdenado.get(2).getListaDeArtistas());
            System.out.println("4. " + TopOrdenado.get(3).getNombreCancion() + TopOrdenado.get(3).getListaDeArtistas());
            System.out.println("5. " + TopOrdenado.get(4).getNombreCancion() + TopOrdenado.get(4).getListaDeArtistas());
            System.out.println("6. " + TopOrdenado.get(5).getNombreCancion() + TopOrdenado.get(5).getListaDeArtistas());
            System.out.println("7. " + TopOrdenado.get(6).getNombreCancion() + TopOrdenado.get(6).getListaDeArtistas());
            System.out.println("8. " + TopOrdenado.get(7).getNombreCancion() + TopOrdenado.get(7).getListaDeArtistas());
            System.out.println("9. " + TopOrdenado.get(8).getNombreCancion() + TopOrdenado.get(8).getListaDeArtistas());
            System.out.println("10. " + TopOrdenado.get(9).getNombreCancion() + TopOrdenado.get(9).getListaDeArtistas());

        }
        return TopOrdenado;
    }

    @Override
    public MyList<Cancion> Top5(LocalDate dia) {
        return null;
    }

    @Override
    public MyList<Artista> Top7Artistas(LocalDate fechaInicio, LocalDate fechaFin) {
        return null;
    }

    @Override
    public int numeroArtistaTop(LocalDate fecha, Artista artista) {
        return 0;
    }

    @Override
    public int CantidadCanciones(LocalDate fechaInicio, LocalDate fechaFin, float tempoMenor, float tempoMayor) {
        return 0;
    }
}