package t1.caso1;

public class Estudiante {
    // 1. ATRIBUTOS PRIVADOS
    private String nombre;
    private int edad;
    private String carrera;

    // 2. CONSTRUCTOR SEGURO 
    public Estudiante(String nombre, int edad, String carrera) {
        // Protección contra cadenas vacías o nulas
        if (nombre == null || nombre.trim().isEmpty()) {
            this.nombre = "Sin Nombre";
        } else {
            this.nombre = nombre;
        }

        // Validación de coherencia para la edad
        if (edad >= 0) {
            this.edad = edad;
        } else {
            this.edad = 0; // Estado por defecto seguro
       }

        if (carrera == null || carrera.trim().isEmpty()) {
            this.carrera = "No Especificada";
        } else {
            this.carrera = carrera;
        }
    }

    // 3. MÉTODOS DE ACCESO PÚBLICO
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        }
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        // Regla de validación
        if (edad >= 0) {
            this.edad = edad;
        } else {
            System.out.println("❌ Error: La edad no puede ser menor a cero.");
        }
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        if (carrera != null && !carrera.trim().isEmpty()) {
            this.carrera = carrera;
        }
    }

    // 4. MÉTODO PARA MOSTRAR DATOS
    public void mostrarDatos() {
        System.out.println("------------------------------------------------");
        System.out.println("🎓 Estudiante : " + this.nombre);
        System.out.println("🔹 Edad       : " + this.edad + " años");
        System.out.println("🔹 Carrera    : " + this.carrera);
    }
}