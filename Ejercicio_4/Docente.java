public class Docente extends Persona {
    private String especialidad;

    public Docente(String nombre, int edad, String especialidad) {
        super(nombre, edad);
        this.especialidad = especialidad;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("\n--- Datos del Docente ---");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Especialidad: " + especialidad);
    }
}