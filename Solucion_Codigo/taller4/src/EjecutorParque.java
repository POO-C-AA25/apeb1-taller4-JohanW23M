import java.util.Scanner;

public class EjecutorParque {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         int numVisitantes;
        System.out.println("Ingrese la cantidad de visitantes a registrar: ");
        numVisitantes = scanner.nextInt();
        scanner.nextLine();  
        Parque parque = new Parque(numVisitantes);

        for (int i = 0; i < numVisitantes; i++) {
            System.out.println("Ingrese el nombre del visitante #" + (i + 1) + ": ");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese la edad de " + nombre + ": ");
            int edad = scanner.nextInt();

            System.out.println("Ingrese la altura de " + nombre + ": ");
            double altura = scanner.nextDouble();
            scanner.nextLine();  // Limpiar buffer

            Visitante visitante = new Visitante(nombre, edad, altura);
            parque.agregarVisitante(visitante);
        }

        parque.verificarAcceso("Montaña Rusa", 12, 1.5);  

        parque.mostrarResumen();
    }
}

class Parque {
    public Visitante[] visitantes;
    public int cantidadVisitantes; 
    public int cantidadVisitantesAptos;
    public int cantidadVisitantesNoAptos;

    public Parque(int maxVisitantes) {
        this.visitantes = new Visitante[maxVisitantes];  
        this.cantidadVisitantes = 0;
        this.cantidadVisitantesAptos = 0;
        this.cantidadVisitantesNoAptos = 0;
    }

    public void agregarVisitante(Visitante visitante) {
        if (cantidadVisitantes < visitantes.length) {
            visitantes[cantidadVisitantes] = visitante;
            cantidadVisitantes++;
        } else {
            System.out.println("No se pueden agregar más visitantes. El parque está lleno.");
        }
    }

    public void verificarAcceso(String nombreJuego, int edadMinima, double alturaMinima) {
        System.out.println("Verificando acceso al juego: " + nombreJuego);
        
        for (int i = 0; i < cantidadVisitantes; i++) {
            Visitante visitante = visitantes[i];
            if (visitante.esApto(edadMinima, alturaMinima)) {
                System.out.println(visitante.getNombre() + " puede acceder a " + nombreJuego);
                cantidadVisitantesAptos++;
            } else {
                System.out.println(visitante.getNombre() + " NO puede acceder a " + nombreJuego);
                cantidadVisitantesNoAptos++;
            }
        }
    }

    public void mostrarResumen() {
        System.out.println("Resumen del dia:");
        System.out.println("Visitantes aptos: " + cantidadVisitantesAptos);
        System.out.println("Visitantes no aptos: " + cantidadVisitantesNoAptos);
    }
}

class Visitante {
    public String nombre;
    public int edad;
    public double altura;

    public Visitante() {
    }

    public Visitante(String nombre, int edad, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
    }

    public boolean esApto(int edadMinima, double alturaMinima) {
        return this.edad >= edadMinima && this.altura >= alturaMinima;
    }

   

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getAltura() {
        return altura;
    } 
    @Override
    public String toString() {
        return "Visitante [Nombre=" + nombre + ", Edad=" + edad + ", Altura=" + altura + "]";
    }
}
