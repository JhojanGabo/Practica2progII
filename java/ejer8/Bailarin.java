package ejer8;

public class Bailarin {
	    private String nombre;
	    private int edad;
	    private String ci;

	    public Bailarin(String nombre, int edad, String ci) {
	        this.nombre = nombre;
	        this.edad = edad;
	        this.ci = ci;
	    }

	    public String getCi() {
	        return ci;
	    }

	    public int getEdad() {
	        return edad;
	    }

	    public void mostrar() {
	        System.out.println("    - " + nombre + " (CI: " + ci + ", Edad: " + edad + ")");
	    }

}
