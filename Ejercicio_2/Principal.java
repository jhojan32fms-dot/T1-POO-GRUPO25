
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static boolean validarDni(String dni) {
        return dni != null && dni.matches("\\d{8}");
    }

    public static CuentaBancaria buscarCuenta(ArrayList<CuentaBancaria> cuentas, String dni) {
        for (CuentaBancaria c : cuentas) {
            if (c.getDni().equals(dni)) {
                return c;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<CuentaBancaria> cuentas = new ArrayList<>();

        cuentas.add(new CuentaBancaria("Juan Perez", "12345678", "juan@gmail.com", 1500));
        cuentas.add(new CuentaBancaria("Maria Lopez", "87654321", "maria@gmail.com", 2500));
        cuentas.add(new CuentaBancaria("Carlos Gomez", "11223344", "carlos@gmail.com", 3500));
        cuentas.add(new CuentaBancaria("Ana Torres", "44332211", "ana@gmail.com", 4500));
        cuentas.add(new CuentaBancaria("Luis Ramirez", "55667788", "luis@gmail.com", 5500));
        cuentas.add(new CuentaBancaria("Sofia Rodriguez", "99887766", "usagi@gmail.com", 6500));
        int opcion;

        do {
            System.out.println("\n===== SISTEMA BANCARIO JM =====");
            System.out.println("1. Crear Cuenta");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Mostrar Cuentas");
            System.out.println("5. Ver Historial");
            System.out.println("6. Total Cuentas");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = Integer.parseInt(sc.nextLine());

            try {
                switch (opcion) {

                    case 1:
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        System.out.print("DNI (8 dígitos): ");
                        String dni = sc.nextLine();

                        if (!validarDni(dni)) {
                            System.out.println("DNI inválido.");
                            break;
                        }

                        System.out.print("Correo: ");
                        String correo = sc.nextLine();

                        System.out.print("Saldo inicial: ");
                        double saldo = Double.parseDouble(sc.nextLine());

                        CuentaBancaria nueva = new CuentaBancaria(nombre, dni, correo, saldo);
                        cuentas.add(nueva);

                        System.out.println("Cuenta creada correctamente.");
                        System.out.println("Número de cuenta: " + nueva.getNumeroCuenta());
                        break;

                    case 2:
                        System.out.print("Ingrese DNI: ");
                        dni = sc.nextLine();

                        if (!validarDni(dni)) {
                            System.out.println("DNI inválido.");
                            break;
                        }

                        CuentaBancaria cuentaDep = buscarCuenta(cuentas, dni);

                        if (cuentaDep == null) {
                            System.out.println("Cuenta no encontrada.");
                            break;
                        }

                        System.out.print("Monto a depositar: ");
                        double deposito = Double.parseDouble(sc.nextLine());

                        cuentaDep.depositar(deposito);
                        System.out.println("Depósito realizado.");
                        System.out.println("Saldo actual: S/ " + cuentaDep.getSaldo());
                        break;

                    case 3:
                        System.out.print("Ingrese DNI: ");
                        dni = sc.nextLine();

                        if (!validarDni(dni)) {
                            System.out.println("DNI inválido.");
                            break;
                        }

                        CuentaBancaria cuentaRet = buscarCuenta(cuentas, dni);

                        if (cuentaRet == null) {
                            System.out.println("Cuenta no encontrada.");
                            break;
                        }

                        System.out.println("Saldo disponible: S/ " + cuentaRet.getSaldo());

                        System.out.print("Monto a retirar: ");
                        double retiro = Double.parseDouble(sc.nextLine());

                        cuentaRet.retirar(retiro);

                        System.out.println("Retiro realizado.");
                        System.out.println("Saldo actual: S/ " + cuentaRet.getSaldo());
                        break;

                    case 4:
                        for (CuentaBancaria cuenta : cuentas) {
                            cuenta.mostrarDatos();
                        }
                        break;

                    case 5:
                        System.out.print("Ingrese DNI: ");
                        dni = sc.nextLine();

                        CuentaBancaria cuentaHist = buscarCuenta(cuentas, dni);

                        if (cuentaHist == null) {
                            System.out.println("Cuenta no encontrada.");
                            break;
                        }

                        System.out.println("=== HISTORIAL ===");
                        for (String movimiento : cuentaHist.getHistorial()) {
                            System.out.println(movimiento);
                        }
                        break;

                    case 6:
                        System.out.println("Total de cuentas: " + CuentaBancaria.getTotalCuentas());
                        break;

                    case 7:
                        System.out.println("Gracias por utilizar el sistema.");
                        break;

                    default:
                        System.out.println("Opción inválida.");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (opcion != 7);

        sc.close();
    }
}
