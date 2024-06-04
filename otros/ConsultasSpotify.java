package otros;

import TADS.LinkedList.src.LinkedList;
import TADS.hash.Hash;
import TADS.hash.MyHash;
import TADS.LinkedList.src.MyList;


import java.time.LocalDate;

public class ConsultasSpotify<V extends Comparable<V>> implements Consultas {
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

    public void Top10(String pais, LocalDate dia) {
        String diaString = String.valueOf(dia);
        MyList<Count> TopOrdenado = new LinkedList();
        int contador = 0;
        if (miHash == null) {
            return;
        } else if (miHash.contains(diaString)) {
            Hash HashPais = (Hash) miHash.get(diaString);
            if (HashPais.contains(pais)) {
                Hash HashCanciones = (Hash) HashPais.get(pais);
                for (int i = 0; i < HashCanciones.getCapacity(); i++) {
                    if (HashCanciones.getTable()[i] != null) {
                        Cancion candionTemp = (Cancion) HashCanciones.getTable()[i].getValue();
                        if (candionTemp.getDailyRank() <= 10) {
                            Count<Cancion> micount = new Count<>(candionTemp, candionTemp.getDailyRank());
                            TopOrdenado.add(micount);
                        }
                    }
                }
            }
        }

        System.out.println("Top 10 canciones mas escuchadas en " + pais + " en el dia " + dia);
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (TopOrdenado.get(j).getCount() == i) {
                    Cancion canionTemp = (Cancion) TopOrdenado.get(j).getValue();
                    System.out.println(i + "-" + canionTemp.getNombreCancion() + " " + canionTemp.getListaDeArtistas().toString());
                }

            }
        }
    }


    @Override
    public void Top5(LocalDate dia) {
        String ndia = String.valueOf(dia);
        MyHash paises = miHash.get(ndia);
        MyList<Cancion> milista = new LinkedList<>();
        MyList<Count<Cancion>> listacontadora = new LinkedList<>();

        if (paises == null) {
            System.out.println("no hay Top 5 de canciones para este dia");
            return;
        }
        milista = Top50(dia, milista);
        for (int i = 0; i < milista.size(); i++) {
            Count<Cancion> cancionCont = new Count(milista.get(i), 1);
            int miIndice = listacontadora.search(cancionCont);
            if (miIndice != -1) {
                int tempcount = listacontadora.get(miIndice).getCount() + 1;
                listacontadora.get(miIndice).setCount(tempcount);
            } else {
                listacontadora.AddInOrder(cancionCont);
            }
        }
        for (int k = listacontadora.size() - 1; k > listacontadora.size() - 6; k--) {
            Cancion cancion = (Cancion) listacontadora.get(k).getValue();
            System.out.println(cancion.getNombreCancion());
        }

    }

    @Override
    public void Top7Artistas(LocalDate fechaInicio, LocalDate fechaFin) {
        MyList<Cancion> milista = new LinkedList();
        MyList<Cancion> milista1 = new LinkedList<>();
        MyList<Count<V>> lisacontadora = new LinkedList<>();
        int contador=0;
        for (LocalDate date = fechaInicio; !date.isAfter(fechaFin); date = date.plusDays(1)) {
            milista1 = Top50(date, milista1);
            contador++;
        }
        if(milista1.size()==0){
            System.out.println("No hay datos para esta fecha");
            return;
        }
        for (int f = 0; f < milista1.size(); f++) {
            if (!milista.contains(milista1.get(f))) {
                milista.add(milista1.get(f));
            }
        }for (int i = 0; i < milista.size(); i++) {
            MyList<Artista> artistasi = milista.get(i).listaDeArtistas;
            for (int j = 0; j < artistasi.size(); j++) {
                Count artistacont = new Count<>(artistasi.get(j), 1);
                int indice = lisacontadora.search(artistacont);
                if (indice != -1) {
                    int tempcount = lisacontadora.get(indice).getCount() + 1;
                    lisacontadora.get(indice).setCount(tempcount);
                } else {
                    lisacontadora.AddInOrder(artistacont);
                }
            }
        }
        for (int p = lisacontadora.size() - 1; p > lisacontadora.size() - 8; p--) {
            Artista artista = (Artista) lisacontadora.get(p).getValue();
            System.out.println(artista.getNombre());
        }
    }

    @Override
    public void numeroArtistaTop(LocalDate fecha, Artista artista) {
        MyList<Cancion> milista = new LinkedList();
        milista = Top50(fecha, milista);
        int cantidad = 0;
        for (int i = 0; i < milista.size(); i++) {
            if (milista.get(i).getListaDeArtistas().contains(artista)) {
                cantidad++;
            }
        }
        System.out.println(cantidad);
    }


    @Override
    public void CantidadCanciones(LocalDate fechaInicio, LocalDate fechaFin, float tempoMenor, float tempoMayor) {
        MyList<Cancion> milista = new LinkedList<>();
        for (LocalDate date = fechaInicio; !date.isAfter(fechaFin); date = date.plusDays(1)) {
            milista = CancionesTempos(date, milista, tempoMenor, tempoMayor);
        }
        System.out.println(milista.size());
    }

    public MyList<Cancion> Top50(LocalDate dia, MyList milista) {
        String diaString = String.valueOf(dia);
        if (miHash == null) {
            return null;
        } else if (miHash.contains(diaString)) {
            Hash hashdia = (Hash) miHash.get(diaString);
            for (int i = 0; i < hashdia.getCapacity(); i++) {
                if (hashdia.getTable()[i] != null) {
                    Hash hashpais = (Hash) hashdia.getTable()[i].getValue();
                    for (int j = 0; j < hashpais.getCapacity(); j++) {
                        if (hashpais.getTable()[j] != null) {
                            Cancion cancioni = (Cancion) hashpais.getTable()[j].getValue();
                            if (cancioni.getDailyRank() <= 50) {
                                milista.AddInOrder(cancioni);
                            }
                        }
                    }
                }
            }
        }
        return milista;
    }

    public MyList<Count<V>> listaOrdenada(int top, MyList<Count<V>> milista) {
        MyList resultado = new LinkedList();
        int indice = 0;
        while (resultado.size() <= top) {
            Count temp = milista.get(0);
            for (int i = 0; i < milista.size(); i++) {
                if (temp.compareTo(milista.get(i + 1)) >= 0) {
                    temp = milista.get(i + 1);
                    indice = i + 1;
                }
            }
            milista.remove(indice);
            resultado.add(temp);
        }
        return resultado;
    }

    public MyList<Cancion> CancionesTempos(LocalDate dia, MyList milista, float tempoMenor, float tempoMayor) {
        String diaString = String.valueOf(dia);
        if (miHash == null) {
            return null;
        } else if (miHash.contains(diaString)) {
            Hash hashdia = (Hash) miHash.get(diaString);
            for (int i = 0; i < hashdia.getCapacity(); i++) {
                if (hashdia.getTable()[i] != null) {
                    Hash hashpais = (Hash) hashdia.getTable()[i].getValue();
                    for (int j = 0; j < hashpais.getCapacity(); j++) {
                        if (hashpais.getTable()[j] != null) {
                            Cancion cancioni = (Cancion) hashpais.getTable()[j].getValue();
                            if (cancioni.tempo < tempoMayor && cancioni.tempo > tempoMenor && !milista.contains(cancioni)) {
                                milista.add(cancioni);
                            }
                        }
                    }
                }
            }

        }return milista;
    }
}
