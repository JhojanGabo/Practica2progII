package persis6;

public class Libro {
	String codigo, titulo;
    double precio;
    public Libro(String c, String t, double p) { this.codigo = c; this.titulo = t; this.precio = p; }
    public String getCodigo() { return codigo; }
    public double getPrecio() { return precio; }
    @Override public String toString() { return "[L] " + titulo + " (" + precio + "Bs)"; }
}
