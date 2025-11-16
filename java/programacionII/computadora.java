package programacionII;

public class computadora {
	    private int anioEnsamblaje;
	    private ram Ram;
	    private discoduro disco;

	    public computadora(int anioEnsamblaje, int capRam, String marcaRam, String tipoRam, int capDisco, String marcaDisco, String modeloDisco) {
	        this.anioEnsamblaje = anioEnsamblaje;
	        this.Ram = new ram(capRam, marcaRam, tipoRam);
	        this.disco = new discoduro(capDisco, marcaDisco, modeloDisco);
	    }

	    public computadora(int anioEnsamblaje, ram Ram, discoduro disco) {
	        this.anioEnsamblaje = anioEnsamblaje;
	        this.Ram = Ram;
	        this.disco = disco;
	    }
	    
	    public computadora() {
	        this.anioEnsamblaje = 2025;
	        this.Ram = new ram(8, "Kingston", "DDR4");
	        this.disco = new discoduro(500, "Seagate", "HDD");
	    }

	    public void encender() {
	        System.out.println("Computadora " + anioEnsamblaje + " encendiendo...");
	    }

	    public void mostrar() {
	        System.out.println("--- Computadora " + anioEnsamblaje + " ---");
	        Ram.mostrar();
	        disco.mostrar();
	        System.out.println("---------------------------");
	    }

	    public void modificarCapacidadRam(int nuevaCapacidad) {
	        Ram.setCapacidad(nuevaCapacidad);
	        System.out.println("Capacidad de RAM modificada a " + nuevaCapacidad + "GB.");
	    }

	    public void modificarCapacidadDisco(int nuevaCapacidad) {
	        disco.setCapacidad(nuevaCapacidad);
	        System.out.println("Capacidad de Disco modificada a " + nuevaCapacidad + "GB.");
	    }

}
