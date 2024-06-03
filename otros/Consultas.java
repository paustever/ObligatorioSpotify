package otros;

import TADS.LinkedList.src.MyList;

import java.time.LocalDate;

public interface Consultas {
    public void Top10(String pais, LocalDate dia);
    public void Top5 (LocalDate dia);

    public void Top7Artistas(LocalDate fechaInicio, LocalDate fechaFin);

    public void numeroArtistaTop(LocalDate fecha, Artista artista);
    public void CantidadCanciones( LocalDate fechaInicio, LocalDate fechaFin, float tempoMenor, float tempoMayor );
}
