package t1.caso1;

import java.util.ArrayList;
import java.util.Scanner;

public class MainCaso1 {
    public static void main(String[] args) {
        // 1. Inicializamos el Scanner para lectura y una lista dinámica para guardar los objetos
        Scanner teclado = new Scanner(System.in);
        ArrayList<Estudiante> lista = new ArrayList<>();
        
        String continuar = "S";

        System.out.println("=== SISTEMA DE REGISTRO DE ESTUDIANTES (T1) ===");

        // 2. Bucle iterativo que registra múltiples estudiantes dinámicamente
        while (continuar.equalsIgnoreCase("S")) {
            try {
                System.out.println("\n--- Ingreso de Datos del Estudiante ---");
                
                System.out.print("🔹 Ingrese Nombre completo: ");
                String nom = teclado.nextLine();
                
                System.out.print("🔹 Ingrese Edad: ");
                int edad = teclado.nextInt();
                teclado.nextLine(); // Limpieza obligatoria de buffer de línea
                
                System.out.print("🔹 Ingrese Carrera: ");
                String car = teclado.nextLine();

                // Instanciación del objeto y adición inmediata a la colección en memoria
                Estudiante nuevoEstudiante = new Estudiante(nom, edad, car);
                lista.add(nuevoEstudiante);
                
                System.out.print("\n¿Desea registrar otro estudiante? (S/N): ");
                continuar = teclado.next();
                teclado.nextLine(); // Limpieza de buffer

            } catch (Exception e) {
                System.out.println("❌ Error: Formato de edad inválido. Intente nuevamente.");
                teclado.nextLine(); // Limpiar el buffer en caso de error de digitación
            }
        }

        // 3. Bloque de salida
        System.out.println("\n================================================");
        System.out.println("       REPORTE FINAL: ESTUDIANTES REGISTRADOS   ");
        System.out.println("================================================");
        
        for (int i = 0; i < lista.size(); i++) {
            // Saltamos de registro en registro de manera indexada en la memoria
            Estudiante est = lista.get(i); 
            est.mostrarDatos();
        }

        teclado.close();
        System.out.println("\nSistema Finalizado XD.");
    }
}
