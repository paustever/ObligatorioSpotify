import TADS.Hash.Hash;
import TADS.Hash.MyHash;
import TADS.LinkedList.src.MyList;
import TADS.Tree.BinarySearchTree;
import TADS.Tree.MyBinarySearchTree;

import java.time.LocalDate;

public class ConsultasSpotify implements Consultas {
    Hash<String, MyHash<String, MyHash<String, Cancion>>> miHash;

    public ConsultasSpotify() {
        this.miHash = null;
    }

    public Hash<String, MyHash<String, MyHash<String, Cancion>>> getMiHash() {
        return miHash;
    }

    public void setMiHash(Hash<String, MyHash<String, MyHash<String, Cancion>>> miHash) {
        this.miHash = miHash;
    }

    public MyList<Cancion> Top10(String pais, LocalDate dia){
        String diaString = String.valueOf(dia);
        MyBinarySearchTree  Top = new BinarySearchTree(null)  ;
        if (miHash== null){
            return null;
        }else if (miHash.contains(diaString)){
            Hash HashPais = (Hash) miHash.get(diaString);
            if (HashPais.contains(pais)){
                Hash HashCanciones = (Hash) HashPais.get(pais);
                for (int i =0 ;i< HashCanciones.getSize();i++){
                    Cancion candionTemp = (Cancion) HashCanciones.getTable()[i].getValue();
                    if (candionTemp.getDailyRank()<= 10 ){
                        Top.insert(candionTemp.dailyRank,candionTemp);
                    }
                }
            }
        }
        MyList<Cancion> TopOrdenado = Top.inOrder();
        for (int i = 0 ; i< TopOrdenado.size(); i ++){
            System.out.println("Top 10 canciones mas escuchadas en " + pais + " en el dia " + dia);
            System.out.println("1. " + TopOrdenado.get(0));// falta poner los gets de lo q te pide la funcion
            System.out.println("2. " + TopOrdenado.get(1));
            System.out.println("3. " + TopOrdenado.get(2));
            System.out.println("4. " + TopOrdenado.get(3));
            System.out.println("5. " + TopOrdenado.get(4));
            System.out.println("6. " + TopOrdenado.get(5));
            System.out.println("7. " + TopOrdenado.get(6));
            System.out.println("8. " + TopOrdenado.get(7));
            System.out.println("9. " + TopOrdenado.get(8));
            System.out.println("10. " + TopOrdenado.get(9));

        }
        return TopOrdenado;
    }
    public MyList<Cancion> Top5 (LocalDate dia){
        return null;
    }

    public MyList<Artista> Top7Artistas(LocalDate fechaInicio, LocalDate fechaFin){
        return null;
    }

    public int numeroArtistaTop(LocalDate fecha, Artista artista){
        return 0;
    }
    public int CantidadCanciones( LocalDate fechaInicio, LocalDate fechaFin, float tempoMenor, float tempoMayor ){
        return 0;
    }


}
