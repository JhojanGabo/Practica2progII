package persis9;

public class Animal {
	String especie, nombre;
    int cantidad;
    public Animal(String e, String n, int c) { especie = e; nombre = n; cantidad = c; }
    @Override public String toString() { return nombre; }
}