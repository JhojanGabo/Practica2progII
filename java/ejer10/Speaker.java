package ejer10;

public class Speaker {
	    private String nombre;
	    private String apellido;
	    private String ci;

	    public Speaker(String nombre, String apellido, String ci) {
	        this.nombre = nombre;
	        this.apellido = apellido;
	        this.ci = ci;
	    }

	    public String getCi() { return ci; }

	    public void mostrarSpeaker() {
	        System.out.println("Speaker: " + nombre + " " + apellido + 
	                           " | CI: " + ci);
	    }
}
