import TADS.Hash.Hash;
import TADS.Hash.MyHash;
import TADS.LinkedList.src.MyList;

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
        if (miHash== null){
            return null;
        }else if (miHash.contains(diaString)){
            Hash HashPais = (Hash) miHash.get(diaString);
            if (HashPais.contains(pais)){
                Hash HashCanciones = (Hash) HashPais.get(pais);

            }
        }
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
