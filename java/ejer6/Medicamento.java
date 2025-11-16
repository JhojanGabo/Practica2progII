package ejer6;

public class Medicamento {
	    private String nombre;
	    private double precio;
	    private int cantidad;

	    public Medicamento(String nombre, double precio, int cantidad) {
	        this.nombre = nombre;
	        this.precio = precio;
	        this.cantidad = cantidad;
	    }

	    public String getNombre() { return nombre; }

	    public void mostrarMedicamento() {
	        System.out.println("Medicamento: " + nombre + 
	                           " | Precio: " + precio + 
	                           " Bs | Cantidad: " + cantidad);
	    }
}
