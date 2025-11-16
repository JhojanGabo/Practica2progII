package ejer4;

public class Ropa {
	    private String tipo;
	    private String material;

	    public Ropa(String tipo, String material) {
	        this.tipo = tipo;
	        this.material = material;
	    }

	    public String getTipo() {
	        return tipo;
	    }

	    public String getMaterial() {
	        return material;
	    }

	    public void mostrar() {
	        System.out.println("  - Prenda: " + tipo + ", Material: " + material);
	    }
}
