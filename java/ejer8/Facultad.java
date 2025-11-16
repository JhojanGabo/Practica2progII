package ejer8;
import java.util.ArrayList;
import java.util.List;
public class Facultad {
	    private String nombre;
	    private List<Fraternidad> fraternidades;

	    public Facultad(String nombre) {
	        this.nombre = nombre;
	        this.fraternidades = new ArrayList<>();
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void addFraternidad(Fraternidad fraternidad) {
	        this.fraternidades.add(fraternidad);
	    }
	    
	    public List<Fraternidad> getFraternidades() {
	        return fraternidades;
	    }

	    public void mostrarFacultad() {
	        System.out.println("--- Facultad de " + nombre + " ---");
	        for (Fraternidad f : fraternidades) {
	            f.mostrarBailarines();
	            System.out.println();
	        }
	    }

}
