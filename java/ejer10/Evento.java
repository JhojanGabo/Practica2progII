package ejer10;
import java.util.ArrayList;
import java.util.List;
public class Evento {
	    private String nombre;
	    private List<Charla> charlas;

	    public Evento(String nombre) {
	        this.nombre = nombre;
	        this.charlas = new ArrayList<>();
	    }

	    public void addCharla(Charla c) {
	        charlas.add(c);
	    }

	    // a) edad promedio
	    public double edadPromedio() {
	        int suma = 0, cont = 0;
	        for (Charla c : charlas) {
	            for (Participante p : c.getParticipantes()) {
	                suma += p.getEdad();
	                cont++;
	            }
	        }
	        return cont == 0 ? 0 : (double) suma / cont;
	    }
	    public boolean buscarPersona(String nom, String ape) {
	        for (Charla c : charlas) {
	            for (Participante p : c.getParticipantes()) {
	                if (p.getNombre().equals(nom) && p.getApellido().equals(ape))
	                    return true;
	            }
	        }
	        return false;
	    }
	    public void eliminarCharlasPorCi(String ci) {
	        charlas.removeIf(c -> c.getSpeaker().getCi().equals(ci));
	    }
	    public void ordenarCharlas() {
	        charlas.sort((a, b) -> b.cantidadParticipantes() - a.cantidadParticipantes());
	    }

	    public void mostrarEvento() {
	        System.out.println("=== Evento: " + nombre + " ===");
	        for (Charla c : charlas) {
	            c.mostrarCharla();
	            System.out.println("-------------------------");
	        }
	    }
}
