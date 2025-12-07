package persis6;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
GestorBiblioteca gb = new GestorBiblioteca();
        
       
        gb.agregarLibro(new Libro("L1", "Java Avanzado", 150));
        gb.agregarLibro(new Libro("L2", "UML Básico", 70));
        gb.agregarLibro(new Libro("L3", "Patrones de Diseño", 250));
        
        gb.agregarCliente(new Cliente(101, "Pepe Perez"));
        gb.agregarCliente(new Cliente(102, "Ana Lopez"));
        
        gb.agregarPrestamo(new Prestamo("L1", 101, 2)); 
        gb.agregarPrestamo(new Prestamo("L1", 102, 1)); 
        gb.agregarPrestamo(new Prestamo("L2", 102, 5)); 
        
        gb.listarLibrosRango(100, 300); 
        gb.ingresoTotalLibro("L1"); 
        gb.librosNuncaPrestados(); 
        gb.clientesDeLibro("L1"); 
        gb.libroMasPrestado(); 
    }
}

