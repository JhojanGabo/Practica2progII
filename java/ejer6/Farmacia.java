package ejer6;
import java.util.ArrayList;
import java.util.List;
public class Farmacia {
	    private String nombre;
	    private String direccion;
	    private List<Medicamento> medicamentos;
	    private List<Proveedor> proveedores;

	    public Farmacia(String nombre, String direccion) {
	        this.nombre = nombre;
	        this.direccion = direccion;
	        this.medicamentos = new ArrayList<>();
	        this.proveedores = new ArrayList<>();
	    }

	    public void addMedicamento(Medicamento m) {
	        medicamentos.add(m);
	    }

	    public void addProveedor(Proveedor p) {
	        proveedores.add(p);
	    }

	    public void mostrarFarmacia() {
	        System.out.println("=== FARMACIA: " + nombre + " ===");
	        System.out.println("Direccion: " + direccion);
	        System.out.println("\n-- Medicamentos --");
	        for (Medicamento m : medicamentos) {
	            m.mostrarMedicamento();
	        }
	        System.out.println("\n-- Proveedores --");
	        for (Proveedor p : proveedores) {
	            p.mostrarProveedor();
	        }
	    }
}
