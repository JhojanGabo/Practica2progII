package persis7;

public class Niño {
	String nombre;
    int carnet, edad;
    double peso, talla; 

    public Niño(String n, int c, int e, double p, double t) {
        nombre = n; carnet = c; edad = e; peso = p; talla = t;
    }
    @Override public String toString() { return nombre + " CI:" + carnet + " Talla:" + talla; }
}
