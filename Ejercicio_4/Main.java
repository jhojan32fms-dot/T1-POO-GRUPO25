import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Registro de Estudiante ===");
        System.out.print("Nombre: ");
        String nombreEst = sc.nextLine();

        System.out.print("Edad: ");
        int edadEst = sc.nextInt();
        sc.nextLine();

        System.out.print("Carrera: ");
        String carrera = sc.nextLine();

        System.out.println("\n=== Registro de Docente ===");
        System.out.print("Nombre: ");
        String nombreDoc = sc.nextLine();

        System.out.print("Edad: ");
        int edadDoc = sc.nextInt();
        sc.nextLine();

        System.out.print("Especialidad: ");
        String especialidad = sc.nextLine();

        Persona estudiante = new Estudiante(
                nombreEst,
                edadEst,
                carrera
        );

        Persona docente = new Docente(
                nombreDoc,
                edadDoc,
                especialidad
        );

        estudiante.mostrarInformacion();
        docente.mostrarInformacion();

        sc.close();
    }
}