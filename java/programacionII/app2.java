package programacionII;

public class app2 {
	    public static void main(String[] args) {
	        computadora c1 = new computadora(2024, 16, "Corsair", "DDR5", 1000, "Samsung", "SSD");
	        computadora c2 = new computadora(0, 0, null, null, 0, null, null);
	        
	        ram ram3 = new ram(32, "Crucial", "DDR4");
	        discoduro disco3 = new discoduro(2000, "WD", "HDD");
	        computadora c3 = new computadora(2023, ram3, disco3);

	        c1.encender();
	        c1.mostrar();

	        c2.mostrar();
	        c2.modificarCapacidadRam(100); 
	        c2.mostrar();

	        c3.mostrar();
	        c3.modificarCapacidadDisco(4000);
	        c3.mostrar();
	    }
	}


