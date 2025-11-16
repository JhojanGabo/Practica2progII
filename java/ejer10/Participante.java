package ejer10;

public class Participante {
	    private String nombre;
	    private String apellido;
	    private int edad;

	    public Participante(String nombre, String apellido, int edad) {
	        this.nombre = nombre;
	        this.apellido = apellido;
	        this.edad = edad;
	    }

	    public int getEdad() { return edad; }

	    public String getNombre() { return nombre; }
	    public String getApellido() { return apellido; }

	    public void mostrarParticipante() {
	        System.out.println(nombre + " " + apellido + " (" + edad + " años)");
	    }
}
