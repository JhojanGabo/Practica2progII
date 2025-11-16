package ejer6;

public class Proveedor {
	    private String nombre;
	    private String telefono;

	    public Proveedor(String nombre, String telefono) {
	        this.nombre = nombre;
	        this.telefono = telefono;
	    }

	    public void mostrarProveedor() {
	        System.out.println("Proveedor: " + nombre + 
	                           " | Telefono: " + telefono);
	    }
}
