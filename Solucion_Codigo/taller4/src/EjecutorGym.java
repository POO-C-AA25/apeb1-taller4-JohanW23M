import java.util.Scanner;

public class EjecutorGym {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Definir el tamaño máximo de clientes
        System.out.println("Ingrese la cantidad de clientes a registrar: ");
        int numClientes = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        // Crear el gimnasio
        Gimnasio gimnasio = new Gimnasio(numClientes);

        // Registrar clientes
        for (int i = 0; i < numClientes; i++) {
            System.out.println("Ingrese el nombre del cliente #" + (i + 1) + ": ");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese el tipo de ejercicio (Cardio, Fuerza, Estiramiento) para " + nombre + ": ");
            String tipoEjercicio = scanner.nextLine();

            System.out.println("Ingrese la duracion del ejercicio (en minutos) para " + nombre + ": ");
            double duracion = scanner.nextDouble();

            System.out.println("Completo la rutina (true/false): ");
            boolean completo = scanner.nextBoolean();
            scanner.nextLine();  // Limpiar el buffer

            // Crear el cliente y agregarlo al gimnasio
            Cliente cliente = new Cliente(nombre, tipoEjercicio, duracion, completo);
            gimnasio.agregarCliente(cliente);
        }

        // Mostrar resumen
        gimnasio.mostrarResumen();
    }
}
class Gimnasio {
    public Cliente[] clientes;  // Arreglo de clientes
    public int cantidadClientes;  // Número de clientes registrados
    public int totalCompletados;  // Número de clientes que completaron su rutina
    public double totalTiempo;  // Tiempo total invertido en ejercicio

    // Constructor
    public Gimnasio(int maxClientes) {
        this.clientes = new Cliente[maxClientes];
        this.cantidadClientes = 0;
        this.totalCompletados = 0;
        this.totalTiempo = 0;
    }

    // Método para agregar un cliente al gimnasio
    public void agregarCliente(Cliente cliente) {
        if (cantidadClientes < clientes.length) {
            clientes[cantidadClientes] = cliente;
            cantidadClientes++;
            if (cliente.completo) {
                totalCompletados++;
            }
            totalTiempo += cliente.duracion;
        } else {
            System.out.println("No se pueden agregar más clientes. El gimnasio está lleno.");
        }
    }

    // Método para mostrar resumen de la rutina de los clientes
    public void mostrarResumen() {
        System.out.println("Resumen del gimnasio:");
        System.out.println("Total de clientes registrados: " + cantidadClientes);
        System.out.println("Total de clientes que completaron su rutina: " + totalCompletados);
        System.out.println("Tiempo promedio invertido por cliente: " + calcularPromedioTiempo() + " minutos");
    }

    // Método para calcular el promedio de tiempo invertido en la rutina
    public double calcularPromedioTiempo() {
        return cantidadClientes > 0 ? totalTiempo / cantidadClientes : 0;
    }
}
class Cliente {
    public String nombre;
    public String tipoEjercicio;  // Cardio, Fuerza, Estiramiento
    public double duracion;       // Duración en minutos
    public boolean completo;      // Si completó la rutina

    // Constructor
    public Cliente(String nombre, String tipoEjercicio, double duracion, boolean completo) {
        this.nombre = nombre;
        this.tipoEjercicio = tipoEjercicio;
        this.duracion = duracion;
        this.completo = completo;
    }

    // Método para marcar si el cliente completó la rutina
    public void completarRutina(boolean completo) {
        this.completo = completo;
    }

    // Método toString para mostrar la información del cliente
    @Override
    public String toString() {
        return "Cliente [Nombre=" + nombre + ", TipoEjercicio=" + tipoEjercicio + 
                ", Duracion=" + duracion + " minutos, Completó Rutina=" + (completo ? "Sí" : "No") + "]";
    }
}
