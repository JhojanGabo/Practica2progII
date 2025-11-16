package ejer4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class ropero {
	    private String material;
	    private List<Ropa> ropa;
	    private int nroRopas;

	    public ropero(String material) {
	        this.material = material;
	        this.ropa = new ArrayList<>();
	        this.nroRopas = 0;
	    }

	    public void adicionarPrenda(Ropa prenda) {
	        this.ropa.add(prenda);
	        this.nroRopas++;
	        System.out.println("Prenda '" + prenda.getTipo() + "' agregada al ropero.");
	    }

	    public void adicionarNPrendas(int n) {
	        for (int i = 0; i < n; i++) {
	            adicionarPrenda(new Ropa("PrendaGenerica" + i, "Algodon"));
	        }
	    }

	    public void eliminarPrenda(String tipo, String material) {
	        Iterator<Ropa> iter = ropa.iterator();
	        boolean eliminado = false;
	        while (iter.hasNext()) {
	            Ropa r = iter.next();
	            if (r.getTipo().equalsIgnoreCase(tipo) || r.getMaterial().equalsIgnoreCase(material)) {
	                iter.remove();
	                this.nroRopas--;
	                System.out.println("Prenda eliminada: " + r.getTipo() + " de " + r.getMaterial());
	                eliminado = true;
	            }
	        }
	        if (!eliminado) {
	            System.out.println("No se encontraron prendas para eliminar con tipo '" + tipo + "' o material '" + material + "'.");
	        }
	    }

	    public void mostrarPrendas(String tipo, String material) {
	        System.out.println("Mostrando prendas con tipo '" + tipo + "' y material '" + material + "':");
	        boolean encontrado = false;
	        for (Ropa r : ropa) {
	            if (r.getTipo().equalsIgnoreCase(tipo) && r.getMaterial().equalsIgnoreCase(material)) {
	                r.mostrar();
	                encontrado = true;
	            }
	        }
	        if (!encontrado) {
	            System.out.println("  (No se encontraron prendas con esos criterios)");
	        }
	    }

	    public void mostrarTodo() {
	        System.out.println("\n--- Contenido del Ropero de " + material + " (" + nroRopas + " prendas) ---");
	        for (Ropa r : ropa) {
	            r.mostrar();
	        }
	        System.out.println("-------------------------------------------------");
	    }
	
}
