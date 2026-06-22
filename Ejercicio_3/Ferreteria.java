// Sistema básico de gestión de Ferretería
// Aplicación de Programación Orientada a Objetos (POO)

public class Ferreteria {

    public static void main(String[] args) {


        // Creación de objetos Producto
        Producto producto1 = new Producto(
                101,
                "Taladro Bosch",
                "Herramientas",
                350.00,
                10
        );


        Producto producto2 = new Producto(
                102,
                "Martillo Stanley",
                "Herramientas",
                50.00,
                20
        );


        // Creación de objeto Cliente
        Cliente cliente1 = new Cliente(
                1,
                "Carlos Perez",
                "74859632",
                "987654321"
        );


        // Mostrar información inicial

        System.out.println("===== SISTEMA FERRETERIA =====");


        System.out.println("\n--- PRODUCTOS REGISTRADOS ---");

        producto1.mostrarProducto();

        producto2.mostrarProducto();



        System.out.println("\n--- DATOS DEL CLIENTE ---");

        cliente1.mostrarCliente();



        // Realizar una venta

        Venta venta1 = new Venta(
                1001,
                cliente1,
                producto1,
                2
        );


        System.out.println("\n--- PROCESO DE VENTA ---");

        venta1.realizarVenta();



        // Mostrar stock actualizado

        System.out.println("\n--- STOCK ACTUALIZADO ---");

        producto1.mostrarProducto();

    }

}


// ================= CLASE PRODUCTO =================

class Producto {


    private int codigo;
    private String nombre;
    private String categoria;
    private double precio;
    private int stock;



    public Producto(int codigo, String nombre, String categoria,
                    double precio, int stock) {


        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;

    }



    public void mostrarProducto() {


        System.out.println("Codigo: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Categoria: " + categoria);
        System.out.println("Precio: S/ " + precio);
        System.out.println("Stock: " + stock);
        System.out.println("-------------------------");


    }



    public void actualizarStock(int cantidad) {


        stock = stock - cantidad;


    }



    public int getStock() {


        return stock;

    }



    public double getPrecio() {


        return precio;

    }



    public String getNombre() {


        return nombre;

    }

}



// ================= CLASE CLIENTE =================

class Cliente {


    private int idCliente;
    private String nombre;
    private String dni;
    private String telefono;



    public Cliente(int idCliente, String nombre,
                   String dni, String telefono) {


        this.idCliente = idCliente;
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;


    }



    public void mostrarCliente() {


        System.out.println("Codigo Cliente: " + idCliente);
        System.out.println("Nombre: " + nombre);
        System.out.println("DNI: " + dni);
        System.out.println("Telefono: " + telefono);

    }



    public String getNombre() {


        return nombre;

    }

}



// ================= CLASE VENTA =================

class Venta {


    private int codigoVenta;
    private Cliente cliente;
    private Producto producto;
    private int cantidad;



    public Venta(int codigoVenta,
                 Cliente cliente,
                 Producto producto,
                 int cantidad) {


        this.codigoVenta = codigoVenta;
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;


    }



    public void realizarVenta() {


        if(producto.getStock() >= cantidad) {


            double total = producto.getPrecio() * cantidad;


            producto.actualizarStock(cantidad);



            System.out.println("Codigo Venta: " + codigoVenta);

            System.out.println("Cliente: "
                    + cliente.getNombre());

            System.out.println("Producto: "
                    + producto.getNombre());

            System.out.println("Cantidad: "
                    + cantidad);

            System.out.println("Total a pagar: S/ "
                    + total);


            System.out.println("Venta realizada correctamente");


        } else {


            System.out.println("No hay stock disponible");


        }


    }


}