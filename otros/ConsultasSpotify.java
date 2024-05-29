package otros;

import TADS.LinkedList.src.LinkedList;
import TADS.hash.Hash;
import TADS.hash.MyHash;
import TADS.LinkedList.src.MyList;
import TADS.Tree.BinarySearchTree;
import TADS.Tree.MyBinarySearchTree;

import javax.xml.crypto.dsig.CanonicalizationMethod;
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
                for (int i = 0; i < HashCanciones.Size(); i++) {
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
    public void Top5(LocalDate dia) {
        String ndia = String.valueOf(dia);
        MyHash paises = miHash.get(ndia);
        MyList<Cancion> milista = new LinkedList<>();
        MyList<songcount> listacontadora = new LinkedList<songcount>();

        if (paises == null) {
            System.out.println("no hay Top 5 de canciones para este dia");
        }
        milista = Top50(dia, milista);
        for (int i = 0; i < milista.size(); i++) {
            songcount cancionCont = new songcount(milista.get(i), 1);
            int miIndice = listacontadora.search(cancionCont);
            if (miIndice != -1) {
                int tempcount = listacontadora.get(miIndice).getCount() + 1;
                listacontadora.get(miIndice).setCount(tempcount);
            } else {
                listacontadora.add(cancionCont);
            }
        }
        MyList<songcount> resultado = listaOrdenada(5, listacontadora);
        for (int i = 0; i < resultado.size(); i++) {
            Cancion cancion = (Cancion) resultado.get(i).getValue();
            System.out.println((i + 1) + "." + cancion.getNombreCancion() + cancion.getListaDeArtistas());
        }

    }

    @Override
    public void  Top7Artistas(LocalDate fechaInicio, LocalDate fechaFin) {
        MyList<Cancion> milista = new LinkedList();
        MyList<Cancion> milista1 = new LinkedList<>();
        MyList<songcount> lisacontadora = new LinkedList<>();
        for (LocalDate date = fechaInicio; !date.isAfter(fechaFin); date = date.plusDays(1)) {
            milista1 = Top50(date, milista1);
        }
        for (int f = 0; f < milista1.size(); f++) {
            if (!milista.contains(milista1.get(f))) {
                milista.add(milista1.get(f));
            }
        }
        for (int i = 0; i < milista.size(); i++) {
            MyList<Artista> artistasi = milista.get(i).listaDeArtistas;
            for (int j = 0; j < artistasi.size(); j++) {
                songcount artistacont = new songcount<>(artistasi.get(j), 1);
                int indice = lisacontadora.search(artistacont);
                if (indice != -1) {
                    int tempcount = lisacontadora.get(indice).getCount() + 1;
                    lisacontadora.get(indice).setCount(tempcount);
                } else {
                    lisacontadora.add(artistacont);
                }
            }
        }
        MyList<songcount> resultado = listaOrdenada(7, lisacontadora);
        for (int p = 0; p < resultado.size(); p++) {
            Artista artista = (Artista) resultado.get(p).getValue();
            System.out.println((p + 1) + ". " + artista.getNombre());
        }
    }

    @Override
    public int numeroArtistaTop(LocalDate fecha, Artista artista) {
        MyList<Cancion> milista = new LinkedList();
        milista = Top50(fecha, milista);
        int cantidad =0;
        for (int i =0; i< milista.size(); i++){
            if (milista.get(i).getListaDeArtistas().contains(artista)){
                cantidad++;
            }
        }
        return cantidad;
    }


    @Override
    public int CantidadCanciones(LocalDate fechaInicio, LocalDate fechaFin, float tempoMenor, float tempoMayor) {
        MyList<Cancion> milista= new LinkedList<>();
        for (LocalDate date = fechaInicio; !date.isAfter(fechaFin); date = date.plusDays(1)){
            milista= CancionesTempos(date, milista, tempoMenor,tempoMayor);
        }
        return milista.size();
    }

    public MyList<Cancion> Top50(LocalDate dia, MyList milista) {
        String diaString = String.valueOf(dia);
        if (miHash == null) {
            return null;
        } else if (miHash.contains(diaString)) {
            Hash hashdia = (Hash) miHash.get(diaString);
            for (int i = 0; i < hashdia.getSize(); i++) {
                Hash hashpais = (Hash) hashdia.getTable()[i].getValue();
                for (int j = 0; j < hashpais.getSize(); i++) {
                    Cancion cancioni = (Cancion) hashpais.getTable()[j].getValue();
                    if (cancioni.getDailyRank()<=50) {
                        milista.add(cancioni);
                    }
                }
            }
        }
        return milista;
    }

    public MyList<songcount> listaOrdenada (int top, MyList<songcount> milista){
        MyList resultado = new LinkedList();
        int indice= 0 ;
        while (resultado.size()<=top) {
            songcount temp = milista.get(0);
            for (int i = 0; i < milista.size(); i++) {
                if (temp.compareTo(milista.get(i+1)) >=0){
                    temp= milista.get(i+1);
                    indice = i+1 ;
                }
            }
            milista.remove(indice);
            resultado.add(temp);
        }
        return resultado;
    }

    public MyList<Cancion> CancionesTempos(LocalDate dia, MyList milista,float tempoMenor, float tempoMayor ) {
        String diaString = String.valueOf(dia);
        if (miHash == null) {
            return null;
        } else if (miHash.contains(diaString)) {
            Hash hashdia = (Hash) miHash.get(diaString);
            for (int i = 0; i < hashdia.getSize(); i++) {
                Hash hashpais = (Hash) hashdia.getTable()[i].getValue();
                for (int j = 0; j < hashpais.getSize(); i++) {
                    Cancion cancioni = (Cancion) hashpais.getTable()[j].getValue();
                    if (cancioni.tempo<tempoMayor && cancioni.tempo> tempoMenor && !milista.contains(cancioni) ) {
                        milista.add(cancioni);
                    }
                }
            }
        }
        return milista;
    }
}
