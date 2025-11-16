package ejer8;
import java.util.ArrayList;
import java.util.List;
public class Fraternidad {
	    private String nombre;
	    private Bailarin encargado;
	    private List<Bailarin> bailarines;

	    public Fraternidad(String nombre, Bailarin encargado) {
	        this.nombre = nombre;
	        this.encargado = encargado;
	        this.bailarines = new ArrayList<>();
	        if (encargado != null) {
	            this.bailarines.add(encargado);
	        }
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public Bailarin getEncargado() {
	        return encargado;
	    }

	    public List<Bailarin> getBailarines() {
	        return bailarines;
	    }

	    public void addBailarin(Bailarin bailarin) {
	        this.bailarines.add(bailarin);
	    }

	    public void mostrarBailarines() {
	        System.out.println("  Fraternidad: " + nombre);
	        System.out.println("  Encargado: " + encargado.getCi());
	        System.out.println("  Bailarines (" + bailarines.size() + "):");
	        for (Bailarin b : bailarines) {
	            b.mostrar();
	        }
	    }

}
