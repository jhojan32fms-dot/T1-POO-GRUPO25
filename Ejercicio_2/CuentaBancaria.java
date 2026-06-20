
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CuentaBancaria {
    private String nombre;
    private String dni;
    private String correo;
    private String numeroCuenta;
    private double saldo;

    private List<String> historial;

    private static int totalCuentas = 0;
    private static int correlativo = 1912793050;

    public CuentaBancaria(String nombre, String dni, String correo, double saldoInicial) {
        this.nombre = nombre;
        this.dni = dni;
        this.correo = correo;
        this.saldo = saldoInicial;
        this.numeroCuenta = "CTA" + correlativo++;
        this.historial = new ArrayList<>();

        registrarMovimiento("Cuenta creada. Saldo inicial: S/ " + saldoInicial);
        totalCuentas++;
    }

    private void registrarMovimiento(String detalle) {
        historial.add(LocalDateTime.now() + " - " + detalle);
    }

    public void depositar(double monto) throws Exception {
        if (monto <= 0) throw new Exception("El monto debe ser mayor a 0.");
        saldo += monto;
        registrarMovimiento("Depósito: S/ " + monto);
    }

    public void retirar(double monto) throws Exception {
        if (monto <= 0) throw new Exception("El monto debe ser mayor a 0.");
        if (monto > saldo) throw new Exception("Saldo insuficiente.");
        saldo -= monto;
        registrarMovimiento("Retiro: S/ " + monto);
    }

    public String getNombre() { return nombre; }
    public String getDni() { return dni; }
    public String getCorreo() { return correo; }
    public String getNumeroCuenta() { return numeroCuenta; }
    public double getSaldo() { return saldo; }
    public List<String> getHistorial() { return historial; }
    public static int getTotalCuentas() { return totalCuentas; }

    public void mostrarDatos() {
        System.out.println("----------------------------------");
        System.out.println("Cuenta : " + numeroCuenta);
        System.out.println("Cliente: " + nombre);
        System.out.println("DNI    : " + dni);
        System.out.println("Correo : " + correo);
        System.out.println("Saldo  : S/ " + saldo);
        System.out.println("----------------------------------");
    }
}
