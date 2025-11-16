package ejer14;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class Empresa {
	    private String nombre;
	    private List<Empleado> empleados;

	    public Empresa(String nombre) {
	        this.nombre = nombre;
	        this.empleados = new ArrayList<>();
	    }

	    public void agregarEmpleado(Empleado empleado) {
	        this.empleados.add(empleado);
	        System.out.println("Empleado " + empleado.getNombre() + " agregado a " + this.nombre);
	    }

	    public void mostrarInformacion() {
	        System.out.println("=== Empresa: " + nombre + " ===");
	        System.out.println("Empleados (" + empleados.size() + "):");
	        for (Empleado e : empleados) {
	            e.mostrar();
	        }
	        System.out.println("=============================");
	    }

	    public Empleado buscarEmpleado(String nombre) {
	        for (Empleado e : empleados) {
	            if (e.getNombre().equalsIgnoreCase(nombre)) {
	                return e;
	            }
	        }
	        return null;
	    }

	    public void eliminarEmpleado(String nombre) {
	        Iterator<Empleado> iter = empleados.iterator();
	        while (iter.hasNext()) {
	            Empleado e = iter.next();
	            if (e.getNombre().equalsIgnoreCase(nombre)) {
	                iter.remove();
	                System.out.println("Empleado " + nombre + " eliminado.");
	                return;
	            }
	        }
	        System.out.println("Empleado " + nombre + " no encontrado.");
	    }

	    public double calcularPromedioSalarial() {
	        if (empleados.isEmpty()) {
	            return 0.0;
	        }
	        double sumaTotal = 0;
	        for (Empleado e : empleados) {
	            sumaTotal += e.getSalario();
	        }
	        return sumaTotal / empleados.size();
	    }

	    public void listarSalariosMayoresA(double monto) {
	        System.out.println("Empleados con salario mayor a " + monto + ":");
	        boolean encontrado = false;
	        for (Empleado e : empleados) {
	            if (e.getSalario() > monto) {
	                e.mostrar();
	                encontrado = true;
	            }
	        }
	        if (!encontrado) {
	            System.out.println("  (Ninguno)");
	        }
	    }
}
