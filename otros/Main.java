package otros;

import TADS.hash.Hash;
import TADS.hash.MyHash;
import TADS.LinkedList.src.MyList;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataLoader dataLoader = new DataLoader();
        System.out.println("ponga la direccion donde tiene guardado el archivo q quiere subir");
        String archivoCSV = "C:\\Users\\paula\\Desktop\\Obligatorio\\universal_top_spotify_songs.csv";
        boolean seguir = true;
        MyHash datos = null;
        boolean continuar = true;
        while (continuar) {
            System.out.println("Seleccione una opcion ");
            System.out.println("1. Carga de datos ");
            System.out.println("2. otros.Consultas ");
            System.out.println("3. Salir");
            int opcion1 = scanner.nextInt();
            switch (opcion1) {
                case 1:
                    datos = dataLoader.cargarDatosEnHashMap(archivoCSV);
                    System.out.println("La carga de datos se realizo con exito ");
                    System.out.println(datos);
                    break;
                case 2:
                    while (seguir) {
                        System.out.println("Seleccione una opción:");
                        System.out.println("1. Top 10 canciones en un país en un día dado");
                        System.out.println("2. Top 5 canciones que aparecen en más top 50 en un día dado");
                        System.out.println("3. Top 7 artistas que más aparecen en los top 50 para un rango de fechas dado");
                        System.out.println("4. Cantidad de veces que aparece un artista específico en un top 50 en una fecha dada");
                        System.out.println("5. Cantidad de canciones con un tempo en un rango específico para un rango específico de fechas");
                        System.out.println("6. Salir");
                        ConsultasSpotify consultas = new ConsultasSpotify(datos);
                        int opcion2 = scanner.nextInt();
                        switch (opcion2) {
                            case 1:
                                System.out.println("Ingrese el país:");
                                String pais = scanner.nextLine();
                                pais = scanner.nextLine();
                                System.out.println("Ingrese la fecha (YYYY-MM-DD):");
                                LocalDate fecha = LocalDate.parse(scanner.nextLine());
                                consultas.Top10(pais,fecha);
                                break;
                            case 2:
                                System.out.println("Ingrese la fecha (YYYY-MM-DD):");
                                String dia = scanner.nextLine();
                                LocalDate fecha2 = LocalDate.parse(scanner.nextLine());
                                consultas.Top5(fecha2);
                                break;
                            case 3:
                                System.out.println("Ingrese la fecha de inicio (YYYY-MM-DD):");
                                String dia2 = scanner.nextLine();
                                LocalDate fechaInicio = LocalDate.parse(scanner.nextLine());
                                System.out.println("Ingrese la fecha de fin (YYYY-MM-DD):");
                                LocalDate fechaFin = LocalDate.parse(scanner.nextLine());
                                consultas.Top7Artistas(fechaInicio,fechaFin);
                                break;
                            case 4:
                                System.out.println("Ingrese la fecha (YYYY-MM-DD):");
                                String dia3 = scanner.nextLine();
                                LocalDate fecha3 = LocalDate.parse(scanner.nextLine());
                                System.out.println("Ingrese el nombre del artista");
                                String nombreArtista = scanner.nextLine();
                                MyList<Artista> listaArtistas = dataLoader.getListadeArtistasGeneral();
                                Artista artista=new Artista(nombreArtista);
                                consultas.numeroArtistaTop(fecha3, artista);
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
                                consultas.CantidadCanciones(fechaInicio1,fechaFin1,tempoInicio,tempoFin);
                                break;
                            case 6:
                                System.out.println("Usted salio del menu ");
                                seguir = false;
                                continuar= false;
                                break;
                            default:
                                System.out.println("El numero que eligio no es una opcion valida, ingrese otro numero");
                                break;
                        }
                    }
                case 3:
                    System.out.println("Usted salio del programa ");
                    continuar= false;
                    break;
                default:
                    System.out.println("El numero que eligio no es una opcion valida, ingrese otro numero");
            }
        }
    }
}

