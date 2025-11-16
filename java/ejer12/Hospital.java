package ejer12;
import java.util.ArrayList;
import java.util.List;

public class Hospital {
	    private String nombre;
	    private List<Doctor> doctores;

	    public Hospital(String nombre) {
	        this.nombre = nombre;
	        this.doctores = new ArrayList<>();
	    }

	    public void asignarDoctor(Doctor doctor) {
	        this.doctores.add(doctor);
	        System.out.println("El Dr. " + doctor.getNombre() + " ha sido asignado al " + this.nombre);
	    }

	    public void mostrarDoctores() {
	        System.out.println("Doctores en " + this.nombre + ":");
	        if (doctores.isEmpty()) {
	            System.out.println("  (No hay doctores asignados)");
	        }
	        for (Doctor doctor : doctores) {
	            doctor.mostrar();
	        }
	    }

}
