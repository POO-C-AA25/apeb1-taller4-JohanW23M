import java.util.Scanner;

public class EjecutorEmpleado {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Empleado empleado1 = new Empleado("Juan", 1500, 30);
        Empleado empleado2 = new Empleado("Ana", 800, 25);
        Empleado empleado3 = new Empleado("Carlos", 1200, 40);
        
        System.out.println("Lista de empleados:");
        empleado1.mostrarEmpleado();
        empleado2.mostrarEmpleado();
        empleado3.mostrarEmpleado();
        
        double salarioPromedio = Empleado.calcularSalarioPromedio(empleado1, empleado2, empleado3);
        System.out.println("Salario promedio de los empleados: " + salarioPromedio);
        
        System.out.println("Ingrese el porcentaje de aumento salarial: ");
        double porcentajeAumento = scanner.nextDouble();
        
        empleado1.aplicarAumentoSalario(salarioPromedio, porcentajeAumento);
        empleado2.aplicarAumentoSalario(salarioPromedio, porcentajeAumento);
        empleado3.aplicarAumentoSalario(salarioPromedio, porcentajeAumento);
        
        System.out.println("Lista de empleados después de aplicar aumento: ");
        empleado1.mostrarEmpleado();
        empleado2.mostrarEmpleado();
        empleado3.mostrarEmpleado();
    }
}

class Empleado {
    public String nombre;
    public double salario;
    public int edad;

    public Empleado() {
    }
    
    public Empleado(String nombre, double salario, int edad) {
        this.nombre = nombre;
        this.salario = salario;
        this.edad = edad;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void mostrarEmpleado() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Empleado [Nombre=" + nombre + ", Salario=" + salario + ", Edad=" + edad + "]";
    }

    public static double calcularSalarioPromedio(Empleado empleado1, Empleado empleado2, Empleado empleado3) {
        double sumaSalarios = 0.0;
        Empleado[] empleados = {empleado1, empleado2, empleado3};
        for (int i = 0; i < empleados.length; i++) {
            sumaSalarios += empleados[i].getSalario();
        }
        return sumaSalarios / empleados.length;
    }

    public void aplicarAumentoSalario(double salarioPromedio, double porcentajeAumento) {
        double nuevoSalario;
        if (this.salario < salarioPromedio) {
            nuevoSalario = this.salario * (1 + porcentajeAumento / 100);
            this.setSalario(nuevoSalario);
            System.out.println("Nuevo salario de " + this.nombre + ": " + nuevoSalario);
        }
    }
}
