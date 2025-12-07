package persis6;

public class Prestamo {
	String codLibro;
    int ciCliente;
    int cantidad;
    public Prestamo(String cl, int cc, int ca) { this.codLibro = cl; this.ciCliente = cc; this.cantidad = ca; }
    public String getCodLibro() { return codLibro; }
    public int getCantidad() { return cantidad; }
    public int getCiCliente() { return ciCliente; }
    @Override public String toString() { return "Prestamo: Cliente CI " + ciCliente + " llevo " + cantidad + " de " + codLibro; }
}
