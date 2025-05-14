import java.util.Scanner;

public class EjecutorAutobusEscolar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int aceptados = 0;
        int rechazados = 0;

        System.out.println("cuantos estudiantes desea registrar: ");
        int numEstudiantes = scanner.nextInt();
        scanner.nextLine();  

        Estudiante[] estudiantes = new Estudiante[numEstudiantes];
        int grado;
        String nombre;
        boolean permisoVigente;
        for (int i = 0; i < numEstudiantes; i++) {
            System.out.println("Ingrese el nombre del estudiante #" + (i + 1) + ": ");
            nombre = scanner.nextLine();

            System.out.println("Ingrese el grado de " + nombre + ": ");
            grado = scanner.nextInt();

            System.out.println("El estudiante tiene permiso vigente (true/false): ");
            permisoVigente = scanner.nextBoolean();
            scanner.nextLine();  

            estudiantes[i] = new Estudiante(nombre, grado, permisoVigente);
        }

        for (int i = 0; i < estudiantes.length; i++) {
            Estudiante estudiante = estudiantes[i];
            if (estudiante.getPermiso()) {
                aceptados++;
                System.out.println(estudiante.getNombre() + " puede subir al autobús.");
            } else {
                rechazados++;
                System.out.println(estudiante.getNombre() + " no puede subir al autobús.");
            }
        }

        System.out.println("Resumen del ingreso de estudiantes:");
        System.out.println("Estudiantes aceptados: " + aceptados);
        System.out.println("Estudiantes rechazados: " + rechazados);
    }
}
class Estudiante {
    public String nombre;
    public int grado;
    public boolean permisoVigente;

    public Estudiante() { }

    public Estudiante(String nombre, int grado, boolean permisoVigente) {
        this.nombre = nombre;
        this.grado = grado;
        this.permisoVigente = permisoVigente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public boolean getPermiso() {
        return permisoVigente;
    }

    public void setPermiso(boolean permisoVigente) {
        this.permisoVigente = permisoVigente;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", grado=" + grado +
                ", permisoVigente=" + permisoVigente +
                '}';
    }
}
