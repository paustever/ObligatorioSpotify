package otros;

import TADS.hash.Hash;
import TADS.hash.IllegalArgumentException;
import TADS.hash.MyHash;
import TADS.LinkedList.src.MyList;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

import static otros.ConsultasSpotify.getUsedMemory;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IllegalArgumentException {
        Scanner scanner = new Scanner(System.in);
        DataLoader dataLoader = new DataLoader();
        String lufar="C:\\Users\\paula\\Desktop\\Obligatorio\\universal_top_spotify_songs.csv";
        long meminicial=getUsedMemory();
        long timeini= System.nanoTime();
        boolean seguir = true;
        MyList<Hash>datos = null;
        boolean continuar = true;
        LocalDate fechaminvalida=LocalDate.parse("2023-10-19");
        LocalDate fechamaxvalida=LocalDate.parse("2024-05-14");
        System.out.println("----BIENVENIDO A SPOTIFY----- ");
        System.out.println(" ");
        while (continuar) {
            System.out.println("* * * MENU PRINCIPAL * * * ");
            System.out.println(" ");
            System.out.println("Seleccione una opcion ");
            System.out.println("1. Carga de datos ");
            System.out.println("2. otros.Consultas ");
            System.out.println("3. Salir");
            int opcion1 = scanner.nextInt();
            System.out.println("------------------------------------------------------------------------------");
            switch (opcion1) {
                case 1:
                    System.out.println(" ");
                    System.out.println("ponga la direccion donde tiene guardado el archivo q quiere subir");
                    String archivoCSV = scanner.nextLine();
                    archivoCSV= scanner.nextLine();
                    datos = dataLoader.cargarDatosEnHashMap(archivoCSV);
                    if(datos!=null){
                        System.out.println("La carga de datos se realizo con exito ");
                    }
                    System.out.println(" ");
                    long difmemoria=getUsedMemory()-meminicial;
                    long diftiempo=System.nanoTime()-timeini;
                    System.out.println("diferencia de memoria: " + difmemoria);
                    System.out.println("diferencia de tiempo: " + diftiempo);
                    break;
                case 2:
                    while (seguir) {
                        System.out.println(" ");
                        System.out.println("* * * * * * * * * * CONSULTAS * * * * * * * * * *  ");
                        System.out.println(" ");
                        System.out.println("Seleccione una opción:");
                        System.out.println("1. Top 10 canciones en un país en un día dado");
                        System.out.println("2. Top 5 canciones que aparecen en más top 50 en un día dado");
                        System.out.println("3. Top 7 artistas que más aparecen en los top 50 para un rango de fechas dado");
                        System.out.println("4. Cantidad de veces que aparece un artista específico en un top 50 en una fecha dada");
                        System.out.println("5. Cantidad de canciones con un tempo en un rango específico para un rango específico de fechas");
                        System.out.println("6. Salir");
                        System.out.println(" ");
                        ConsultasSpotify consultas = new ConsultasSpotify(datos);
                        int opcion2 = scanner.nextInt();
                        switch (opcion2) {

                            case 1:
                                System.out.println("Ingrese el país:");
                                String pais = scanner.nextLine();
                                pais = scanner.nextLine();
                                System.out.println("Ingrese la fecha (YYYY-MM-DD):");
                                LocalDate fecha = LocalDate.parse(scanner.nextLine());
                                if (!fechaminvalida.isAfter(fecha) && !fechamaxvalida.isBefore(fecha)) {
                                    consultas.Top10(pais, fecha);
                                    System.out.println(" ");
                                } else {
                                    System.out.println("Ingrese un rango de fechas entre 2023-10-19 y 2024-05-14");
                                    System.out.println(" ");
                                }
                                break;
                            case 2:
                                System.out.println("Ingrese la fecha (YYYY-MM-DD):");
                                String dia = scanner.nextLine();
                                LocalDate fecha2 = LocalDate.parse(scanner.nextLine());
                                if (!fechaminvalida.isAfter(fecha2) && !fechamaxvalida.isBefore(fecha2)) {
                                    consultas.Top5(fecha2);
                                    System.out.println(" ");
                                } else {
                                    System.out.println("Ingrese un rango de fechaas entre 2023-10-19 y 2024-05-14");
                                    System.out.println(" ");
                                }
                                break;
                            case 3:
                                System.out.println("Ingrese la fecha de inicio (YYYY-MM-DD):");
                                String dia2 = scanner.nextLine();
                                LocalDate fechaInicio = LocalDate.parse(scanner.nextLine());
                                System.out.println("Ingrese la fecha de fin (YYYY-MM-DD):");
                                LocalDate fechaFin = LocalDate.parse(scanner.nextLine());
                                if (!fechaminvalida.isAfter(fechaInicio) && !fechamaxvalida.isBefore(fechaInicio) && !fechaminvalida.isAfter(fechaFin) && !fechamaxvalida.isBefore(fechaFin)) {
                                    consultas.Top7Artistas(fechaInicio, fechaFin);
                                    System.out.println(" ");
                                } else {
                                    System.out.println("Ingrese un rango de fechaas entre 2023-10-19 y 2024-05-14");
                                    System.out.println(" ");
                                }
                                break;
                            case 4:
                                System.out.println("Ingrese la fecha (YYYY-MM-DD):");
                                String dia3 = scanner.nextLine();
                                LocalDate fecha3 = LocalDate.parse(scanner.nextLine());
                                System.out.println("Ingrese el nombre del artista");
                                String nombreArtista = scanner.nextLine();
                                Artista artista = new Artista(nombreArtista);
                                if (!fechaminvalida.isAfter(fecha3) && !fechamaxvalida.isBefore(fecha3)) {
                                    consultas.numeroArtistaTop(fecha3, artista);
                                    System.out.println(" ");
                                } else {
                                    System.out.println("Ingrese un rango de fechaas entre 2023-10-19 y 2024-05-14");
                                    System.out.println(" ");
                                }
                                break;
                            case 5:
                                System.out.println("Ingrese la fecha de inicio  (YYYY-MM-DD):");
                                String dia4 = scanner.nextLine();
                                LocalDate fechaInicio1 = LocalDate.parse(scanner.nextLine());
                                System.out.println("Ingrese la fecha de fin (YYYY-MM-DD):");
                                LocalDate fechaFin1 = LocalDate.parse(scanner.nextLine());
                                System.out.println("Ingrese el tempo de inicio (YYYY-MM-DD):");
                                float tempoInicio = Float.parseFloat(scanner.nextLine());
                                System.out.println("Ingrese el tempo de fin (YYYY-MM-DD):");
                                float tempoFin = Float.parseFloat(scanner.nextLine());
                                if (!fechaminvalida.isAfter(fechaInicio1) && !fechamaxvalida.isBefore(fechaInicio1) && !fechaminvalida.isAfter(fechaFin1) && !fechamaxvalida.isBefore(fechaFin1)) {
                                    consultas.CantidadCanciones(fechaInicio1, fechaFin1, tempoInicio, tempoFin);
                                    System.out.println(" ");
                                    break;
                                }
                                System.out.println("Ingrese un rango de fechaas entre 2023-10-19 y 2024-05-14");
                                System.out.println(" ");
                                break;
                            case 6:
                                System.out.println(" ");
                                System.out.println("Usted salio del menu ");
                                seguir = false;
                                continuar= false;
                                break;
                            default:
                                System.out.println(" ");
                                System.out.println("El numero que eligio no es una opcion valida, ingrese otro numero");
                                System.out.println(" ");
                                break;
                        }
                    }
                case 3:
                    System.out.println(" ");
                    System.out.println("Usted salio del programa ");
                    System.out.println(" ");
                    continuar= false;
                    break;
                default:
                    System.out.println(" ");
                    System.out.println("El numero que eligio no es una opcion valida, ingrese otro numero");
                    System.out.println(" ");
            }
        }
        
    }
}

