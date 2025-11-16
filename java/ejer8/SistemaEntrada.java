package ejer8;
import java.util.ArrayList;
import java.util.List;
public class SistemaEntrada {
	    private List<Facultad> facultades;
	    private List<Bailarin> registroBailarines;

	    public SistemaEntrada() {
	        this.facultades = new ArrayList<>();
	        this.registroBailarines = new ArrayList<>();
	    }

	    public void addFacultad(Facultad f) {
	        this.facultades.add(f);
	    }

	    public boolean verificarDuplicado(Bailarin b) {
	        for (Bailarin existente : registroBailarines) {
	            if (existente.getCi().equals(b.getCi())) {
	                return true;
	            }
	        }
	        return false;
	    }

	    public void registrarBailarin(Bailarin b, Fraternidad f) {
	        if (verificarDuplicado(b)) {
	            System.out.println("Error: El bailarin " + b.getCi() + " ya está registrado en otra fraternidad.");
	        } else {
	            f.addBailarin(b);
	            this.registroBailarines.add(b);
	            System.out.println("Bailarin " + b.getCi() + " registrado en " + f.getNombre());
	        }
	    }
	    
	    public void mostrarBailarinesPorFacultad(String nombreFacultad) {
	        for (Facultad fac : facultades) {
	            if (fac.getNombre().equalsIgnoreCase(nombreFacultad)) {
	                System.out.println("Bailarines de la Facultad de " + nombreFacultad + ":");
	                for (Fraternidad frat : fac.getFraternidades()) {
	                    System.out.println("  En Fraternidad " + frat.getNombre() + ":");
	                    for (Bailarin b : frat.getBailarines()) {
	                        b.mostrar();
	                    }
	                }
	                return;
	            }
	        }
	        System.out.println("No se encontró la facultad: " + nombreFacultad);
	    }

	    public void mostrarEdadesParticipantes() {
	        System.out.println("Edades de todos los participantes registrados:");
	        for (Bailarin b : registroBailarines) {
	            System.out.println("  - CI: " + b.getCi() + ", Edad: " + b.getEdad());
	        }
	    }

}
