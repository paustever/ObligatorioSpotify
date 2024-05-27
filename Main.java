import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean seguir = true ;
        while (seguir) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Top 10 canciones en un país en un día dado");
            System.out.println("2. Top 5 canciones que aparecen en más top 50 en un día dado");
            System.out.println("3. Top 7 artistas que más aparecen en los top 50 para un rango de fechas dado");
            System.out.println("4. Cantidad de veces que aparece un artista específico en un top 50 en una fecha dada");
            System.out.println("5. Cantidad de canciones con un tempo en un rango específico para un rango específico de fechas");
            System.out.println("6. Salir");
            int opcion = scanner.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("Ingrese el país:");
                    String pais = scanner.nextLine();
                    System.out.println("Ingrese la fecha (YYYY-MM-DD):");
                    LocalDate fecha = LocalDate.parse(scanner.nextLine());

                    break;
                case 2:
                    System.out.println("Ingrese la fecha (YYYY-MM-DD):");
                    LocalDate fecha2 = LocalDate.parse(scanner.nextLine());
                    break;
                case 3:
                    System.out.println("Ingrese la fecha de inicio (YYYY-MM-DD):");
                    LocalDate fechaInicio = LocalDate.parse(scanner.nextLine());
                    System.out.println("Ingrese la fecha de fin (YYYY-MM-DD):");
                    LocalDate fechaFin = LocalDate.parse(scanner.nextLine());
                    break;
                case 4:
                    System.out.println("Ingrese la fecha (YYYY-MM-DD):");
                    LocalDate fecha3 = LocalDate.parse(scanner.nextLine());
                    System.out.println("Ingrese el nombre del artista");
                    String nombreArtiste = scanner.nextLine();
                    break;
                case 5:
                    System.out.println("Ingrese la fecha de inicio  (YYYY-MM-DD):");
                    LocalDate fechaInicio1 = LocalDate.parse(scanner.nextLine());
                    System.out.println("Ingrese la fecha de fin (YYYY-MM-DD):");
                    LocalDate fechaFin1 = LocalDate.parse(scanner.nextLine());
                    System.out.println("Ingrese el tempo de inicio (YYYY-MM-DD):");
                    float tempoInicio = Float.parseFloat(scanner.nextLine());
                    System.out.println("Ingrese el tempo de fin (YYYY-MM-DD):");
                    float tempoFin = Float.parseFloat(scanner.nextLine());
                    break;
                case 6:
                    System.out.println("Usted salio del menu ");
                    seguir = false;
                    break;
                default:
                    System.out.println("El numero que eligio no es una opcion valida, ingrese otro numero");
                    break;
            }
        }

    }
}
