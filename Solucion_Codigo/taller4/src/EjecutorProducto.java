public class EjecutorProducto {
    public static void main(String[] args) {
        Producto p1 = new Producto(1000, 10);
        p1.calcularDescuento(p1.precioP, p1.cantidadP);
        p1.calcularPrecioFinal();
        System.out.println(p1);
    }
}
class Producto{
    public double precioP; 
    public int cantidadP;
    public double descuento; 
    public double precioFinal;
    public Producto() { }
    public Producto(double precioP, int cantidadP) {
        this.precioP = precioP;
        this.cantidadP = cantidadP;
    }
    public double calcularDescuento(double precioP, int cantidadP){
        this.descuento = 5;
        this.descuento = (precioP>=1000 && cantidadP>=10) ? 10 : 0 ;
        return this.descuento; 
    }
    public double calcularPrecioFinal(){
        this.precioFinal = (this.cantidadP * this.precioP) -
        ((this.cantidadP * this.precioP) *
        (this.descuento/100) );
        return this.precioFinal; 
    }

    @Override
    public String toString() {
        return "Producto{" + "precioP=" + precioP + ", cantidadP=" + cantidadP + ", descuento=" + descuento + ", precioFinal=" + precioFinal + '}';
    }

}