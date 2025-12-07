package persis8;
import java.time.LocalDate;
public class Alimento {
	
	    String nombre;
	    String fechaVencimiento; 
	    int cantidad;

	    public Alimento(String n, String f, int c) { nombre = n; fechaVencimiento = f; cantidad = c; }
	    
	    public boolean estaVencido(String fechaComparacion) {
	        LocalDate fVenc = LocalDate.parse(fechaVencimiento);
	        LocalDate fComp = LocalDate.parse(fechaComparacion);
	        return fVenc.isBefore(fComp);
	    }
	    @Override public String toString() { return nombre + " cant:" + cantidad; }
	}