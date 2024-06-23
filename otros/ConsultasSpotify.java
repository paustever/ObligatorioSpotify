package otros;

import TADS.LinkedList.src.LinkedList;
import TADS.hash.Hash;
import TADS.hash.MyHash;
import TADS.LinkedList.src.MyList;


import java.time.LocalDate;

public class ConsultasSpotify<V extends Comparable<V>> implements Consultas {
    MyHash<String, MyHash<String, MyHash<Integer, Cancion>>> hashtotal;
    MyHash<String, MyHash<String, Count>> hashcount;

    public ConsultasSpotify(MyList<Hash> datos) {
        this.hashtotal = datos.get(0);
        this.hashcount = datos.get(1);
    }


    public void Top10(String pais, LocalDate dia) {
        String diaString = String.valueOf(dia);
        MyList<Count> TopOrdenado = new LinkedList();
        if (hashtotal == null) {
            return;
        } else if (hashtotal.contains(diaString)) {
            Hash HashPais = (Hash) hashtotal.get(diaString);
            if (HashPais.contains(pais)) {
                Hash<Integer, Cancion> HashCanciones = (Hash) HashPais.get(pais);
                System.out.println(" ");
                System.out.println(" * * * Top 10 canciones mas escuchadas en " + pais + " en el dia " + dia + " * * * ");
                System.out.println(" ");
                for (int i = 1; i < 11; i++) {
                    if (HashCanciones.get(i) != null) {
                        System.out.println(i + "-" + HashCanciones.get(i).getNombreCancion() + " " + HashCanciones.get(i).imprimirlista());
                    }
                }
            }
        }
    }

    @Override
    public void Top5(LocalDate dia) {
        String ndia = String.valueOf(dia);
        Hash<String, Count<Cancion>> mihash = (Hash) hashcount.get(ndia);
        MyList<Count<Cancion>> milista = new LinkedList();
        if (mihash != null) {
            for (int i = 0; i < mihash.getCapacity(); i++) {
                if (mihash.getTable()[i] != null && mihash.getTable()[i].getValue().getValue().dailyRank < 51) {
                    Count micount = (Count) mihash.getTable()[i].getValue();
                    milista.AddInOrder(micount);
                }
            }
            int i = 1;
            System.out.println(" ");
            System.out.println("* * * TOP 5 CANCIONES QUE APARECEN EN MAS DE UN TOP 50 EL DIA " + dia + " * * * ");
            System.out.println(" ");
            for (int k = milista.size() - 1; k > milista.size() - 6; k--) {
                Cancion cancion = milista.get(k).getValue();
                int ocurrencias = milista.get(k).getCount();
                System.out.println(i + "- " + cancion.getNombreCancion() + " ocurrencias: " + ocurrencias);
                i++;
            }
        }
    }


    @Override
    public void Top7Artistas(LocalDate fechaInicio, LocalDate fechaFin) {
        MyList<Count<Artista>> listacontadora = new LinkedList<>();
        MyList<Count<Artista>> listaordenada = new LinkedList<>();
        int contador = 0;
        for (LocalDate date = fechaInicio; !date.isAfter(fechaFin); date = date.plusDays(1)) {
            listacontadora = artistasdia(date, listacontadora);
        }
        for (int k = 0; k < listacontadora.size(); k++) {
            listaordenada.AddInOrder(listacontadora.get(k));
        }
        int i = 1;
        System.out.println(" ");
        System.out.println("* * * TOP 7 ARTISTAS  QUE APARECEN EN MAS TOPS 50 DESDE " + fechaInicio + " hasta " + fechaFin);
        System.out.println(" ");
        for (int p = listaordenada.size() - 1; p > listaordenada.size() - 8; p--) {
            if (listaordenada.get(p) != null) {
            Artista artista = (Artista) listaordenada.get(p).getValue();
            int Ocurrencias = listaordenada.get(p).getCount();
            System.out.println(i + "-" + " " + artista.getNombre() + " ocuerrencias: " + Ocurrencias);
            i++;
        }}

    }

    @Override
    public void numeroArtistaTop(LocalDate fecha, Artista artista) {
        int cantidad = 0;
        Hash dia = (Hash) hashcount.get(String.valueOf(fecha));
        if (dia != null) {
            for (int i = 0; i < dia.getCapacity(); i++) {
                if (dia.getTable()[i] != null) {
                    Count<Cancion> tempcancion = (Count<Cancion>) dia.getTable()[i].getValue();
                    if (tempcancion.getValue().getListaDeArtistas().contains(artista) && tempcancion.getValue().dailyRank < 51) {
                        cantidad += tempcancion.getCount();
                    }
                }
            }
        }
        System.out.println(" ");
        System.out.println("El artista de nombre: " + artista.getNombre() + " aparecio " + cantidad + " veces en los Top 50 de el dia " + fecha);
        System.out.println(" ");
    }


    @Override
    public void CantidadCanciones(LocalDate fechaInicio, LocalDate fechaFin, float tempoMenor, float tempoMayor) {
        MyList<Cancion> milista = new LinkedList<>();
        for (LocalDate date = fechaInicio; !date.isAfter(fechaFin); date = date.plusDays(1)) {
            milista = CancionesTempos(date, milista, tempoMenor, tempoMayor);
        }
        System.out.println(" ");
        System.out.println(milista.size() + " canciones tienen un temp entre " + tempoMenor + " y " + tempoMayor + " desde " + fechaInicio + " hasta " + fechaFin);
        System.out.println(" ");
    }

    public MyList artistasdia(LocalDate date, MyList<Count<Artista>> listacontadora) {
        Hash<String, Count> hashtemp = (Hash<String, Count>) hashcount.get(String.valueOf(date));
        if (hashtemp != null) {
            for (int i = 0; i < hashtemp.getCapacity(); i++) {
                if (hashtemp.getTable()[i] != null) {
                    Cancion tempcancion = (Cancion) hashtemp.getTable()[i].getValue().getValue();
                    int count = hashtemp.getTable()[i].getValue().getCount();
                    if (tempcancion.getDailyRank() < 51) {
                        for (int j = 0; j < tempcancion.getListaDeArtistas().size(); j++) {
                            Count<Artista> tempartista = new Count<>(tempcancion.getListaDeArtistas().get(j), 1);
                            int posicion = listacontadora.search(tempartista);
                            if (posicion == -1) {
                                listacontadora.add(tempartista);
                            } else {
                                int valor = listacontadora.get(posicion).getCount() + count;
                                listacontadora.get(posicion).setCount(valor);
                            }
                        }
                    }
                }
            }
        }
        return listacontadora;
    }


    public MyList<Cancion> CancionesTempos(LocalDate dia, MyList<Cancion> milista, float tempoMenor, float tempoMayor) {
        String diaString = String.valueOf(dia);
        if (hashcount == null) {
            return null;
        } else if (hashcount.contains(diaString)) {
            Hash<String, Count<Cancion>> hashdia = (Hash) hashcount.get(diaString);
            for (int i = 0; i < hashdia.getCapacity(); i++) {
                if (hashdia.getTable()[i] != null) {
                    Cancion tempcancion = hashdia.getTable()[i].getValue().getValue();
                    if (!milista.contains(tempcancion) && tempcancion.tempo < tempoMayor && tempcancion.tempo > tempoMenor) {
                        milista.add(tempcancion);
                    }
                }
            }
        }
        return milista;
    }



}
