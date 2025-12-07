package persis6;

public class Cliente {
	int ci;
    String nombre;
    public Cliente(int c, String n) { this.ci = c; this.nombre = n; }
    public int getCi() { return ci; }
    @Override public String toString() { return "[C] " + nombre + " (CI: " + ci + ")"; }
}