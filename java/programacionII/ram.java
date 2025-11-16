package programacionII;

public class ram {
	    private int capacidad;
	    private String marca;
	    private String tipo;

	    public ram(int capacidad, String marca, String tipo) {
	        this.setCapacidad(capacidad);
	        this.marca = marca;
	        this.tipo = tipo;
	    }

	    public int getCapacidad() {
	        return capacidad;
	    }

	    public void setCapacidad(int capacidad) {
	        if (capacidad >= 4 && capacidad <= 64) {
	            this.capacidad = capacidad;
	        } else {
	            System.out.println("Error: Capacidad de RAM debe estar entre 4 y 64 GB.");
	            this.capacidad = 4;
	        }
	    }

	    public String getMarca() {
	        return marca;
	    }

	    public void setMarca(String marca) {
	        this.marca = marca;
	    }

	    public String getTipo() {
	        return tipo;
	    }

	    public void setTipo(String tipo) {
	        this.tipo = tipo;
	    }

	    public void mostrar() {
	        System.out.println("  RAM: " + marca + " " + tipo + " " + capacidad + "GB");
	    }
}
